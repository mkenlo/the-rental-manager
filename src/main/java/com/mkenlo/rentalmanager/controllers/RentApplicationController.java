package com.mkenlo.rentalmanager.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Controller
@RequestMapping("/applications")
public class RentApplicationController {

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

    @GetMapping("/add/property/{propertyId}/step1")
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
        return "rentapplication/add-step-1";
    }

    @PostMapping("/add/property/{propertyId}/step1")
    public String postApplicationStep1(@PathVariable long propertyId,
            @Valid @ModelAttribute("newApplicant") Applicant newApplicant, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("property", propertyService.getById(propertyId));
            return "rentapplication/add-step-1";
        }
        Applicant applicant = applicantService.save(newApplicant);
        model.addAttribute("step", 2);
        return String.format("redirect:/applications/add/property/%s/step2?applicant=%s", propertyId,
                applicant.getId());
    }

    @GetMapping("/add/property/{propertyId}/step2")
    public String startApplicationStep2(@PathVariable("propertyId") long propertyId,
            @RequestParam("applicant") long applicantId, Model model) {
        model.addAttribute("property", propertyService.getById(propertyId));
        model.addAttribute("applicant", applicantService.getById(applicantId));
        model.addAttribute("newApplication", new RentalApplication());
        return "rentapplication/add-step-2";
    }

    @PostMapping("/add/property/{propertyId}/step2")
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
            return "rentapplication/add-step-2";
        }
        newApplication.setStatus("pending");
        newApplication.setApplicant(applicant);
        newApplication.setProperty(property);
        RentalApplication application = rentAppService.save(newApplication);
        redirect.addFlashAttribute("message", "Thank you for submitting your application");
        return String.format("redirect:/applications/%s", application.getId());
    }

    @GetMapping("/{appId}")
    public String getApplicationSummary(@PathVariable("appId") long appId,
            @RequestParam(name = "summary", required = false) boolean summary,
            Model model) {
        RentalApplication application = rentAppService.getById(appId);
        if (application == null)
            return "404";
        model.addAttribute("appli", application);
        return "rentapplication/detail";
    }
}
