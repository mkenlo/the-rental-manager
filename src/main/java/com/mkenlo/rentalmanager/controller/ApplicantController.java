package com.mkenlo.rentalmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    @Autowired
    PropertyService propertyService;

    @Autowired
    UserService userService;

    @ModelAttribute
    public void addAttributes(Model model, Principal principal, HttpSession session) {
        User user;
        String username;
        if (principal != null) {
            username = principal.getName();
        } else if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        } else {
            username = "nogivenusername";
        }
        user = userService.findByUsername(username);
        model.addAttribute("loggedUser", user);
        model.addAttribute("controllerPath", "applicant");

    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        Page<Property> propertiesPaginated = propertyService.getAll(page);
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "applicant";
    }

    @GetMapping("/start/application/{propertyId}")
    public String startApplication(@PathVariable("propertyId") long propertyId, Model model) {
        return "rent-application-add";
    }

    @PostMapping("/start/application")
    public String postApplication() {
        return "redirect:/applicant";
    }

    @GetMapping("/my-applications")
    public String listApplications() {
        return "my-rentapplication-list";
    }

}
