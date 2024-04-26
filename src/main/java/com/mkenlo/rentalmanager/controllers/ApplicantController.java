package com.mkenlo.rentalmanager.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Applicant;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.ApplicantService;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.UserService;

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

    @GetMapping("/applications")
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
        return "rentapplication/list";
    }

}
