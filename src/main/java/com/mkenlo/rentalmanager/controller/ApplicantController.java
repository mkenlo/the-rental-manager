package com.mkenlo.rentalmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.ApplicantService;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    UserService userService;

    @Autowired
    ApplicantService applicantService;

    @Autowired
    RentApplicationService rentAppService;

    @ModelAttribute
    public void addAttributes(Model model, Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findByUsername(username);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("controllerPath", loggedUser.getRoles().get(0).getBaseUrl());
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model,
            RedirectAttributes redirect) {
        Page<Property> propertiesPaginated = propertyService.getAll(page);
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "applicant";
    }

    @GetMapping("/start/application/{propertyId}")
    public String startApplicationStep1(@PathVariable("propertyId") long propertyId, Model model, Principal principal,
            RedirectAttributes redirect) {
        String username = principal.getName();
        User loggedUser = userService.findByUsername(username);
        Applicant applicant = applicantService.getByProfile(loggedUser);
        model.addAttribute("newApplicant", applicant);
        if (applicant == null) {
            model.addAttribute("newApplicant", new Applicant());
        }
        model.addAttribute("property", propertyService.getById(propertyId));
        model.addAttribute("step", 1);
        return "rent-application-add";
    }

    @PostMapping("/start/application/{propertyId}")
    public String postApplicationStep1(@PathVariable long propertyId,
            @Valid @ModelAttribute("newApplicant") Applicant newApplicant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("property", propertyService.getById(propertyId));
            return "rent-application-add";
        }
        Applicant applicant = applicantService.save(newApplicant);
        model.addAttribute("step", 2);
        return String.format("redirect:/applicant/start/application/%s/step2?applicant=%s", propertyId,
                applicant.getId());
    }

    @GetMapping("/start/application/{propertyId}/step2")
    public String startApplicationStep2(@PathVariable("propertyId") long propertyId,
            @RequestParam("applicant") long applicantId, Model model) {
        model.addAttribute("property", propertyService.getById(propertyId));
        model.addAttribute("applicant", applicantService.getById(applicantId));
        model.addAttribute("newApplication", new RentalApplication());
        return "rent-application-add-step-2";
    }

    @PostMapping("/start/application/{propertyId}/step2")
    public String postApplicationStep2(@PathVariable long propertyId, @RequestParam("applicant") long applicantId,
            @Valid @ModelAttribute("newApplication") RentalApplication newApplication, BindingResult result,
            Model model, RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        Applicant applicant = applicantService.getById(applicantId);

        if (property == null || applicant == null) {
            redirect.addFlashAttribute("error", "404 - Object Non Found. Invalid Payload");
            return "404";
        }
        if (result.hasErrors()) {
            model.addAttribute("property", property);
            model.addAttribute("applicant", applicant);
            return "rent-application-add-step-2";
        }
        newApplication.setStatus("pending");
        newApplication.setApplicant(applicant);
        newApplication.setProperty(property);
        RentalApplication application = rentAppService.save(newApplication);
        model.addAttribute("application", application);
        redirect.addFlashAttribute("message", "Thank you for submitting your application");
        return String.format("redirect:/applicant/summary/application/%s", application.getId());
    }

    @GetMapping("/summary/application/{appId}")
    public String applicationSummary(@PathVariable("appId") long appId, Model model) {
        RentalApplication application = rentAppService.getById(appId);
        if (application == null)
            return "404";
        model.addAttribute("application", application);
        return "rent-application-add-final";
    }

    @GetMapping("/my-applications")
    public String listApplications(Model model, Principal principal,
            RedirectAttributes redirect) {
        String username = principal.getName();
        User loggedUser = userService.findByUsername(username);
        if (loggedUser == null) {
            redirect.addFlashAttribute("error", "action requires login");
            return "redirect:/login";
        }

        Applicant applicant = applicantService.getByProfile(loggedUser);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("applications", rentAppService.getByApplicant(applicant));
        return "rent-application-user-list";
    }

}
