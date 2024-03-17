package com.mkenlo.rentalmanager.controller;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    UserService userService;
    PropertyService propertyService;

    public ManagerController(UserService userService, PropertyService propertyService) {
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @ModelAttribute
    public void addAttributes(Model model, Principal principal, HttpSession session) {
        User user;
        String username;
        if (principal != null) {
            username = principal.getName();
        } else if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        } else {
            username = "norole";
        }
        user = userService.findByUsername(username);
        model.addAttribute("loggedUser", user);
        model.addAttribute("controllerPath", "manager");
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model, Principal principal) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        Page<Property> propertiesPaginated = propertyService.getPropertiesByPropertyManager(loggedUser.getManager(),
                page);

        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "manager";
    }
}