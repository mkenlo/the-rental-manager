package com.mkenlo.rentalmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyOccupationService;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    UserService userService;
    PropertyService propertyService;

    @Autowired
    RentApplicationService rentAppService;

    @Autowired
    PropertyOccupationService occupationService;

    public ManagerController(UserService userService, PropertyService propertyService) {
        this.userService = userService;
        this.propertyService = propertyService;
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        // @TODO add Spring Security and save user info in model here
        model.addAttribute("controllerPath", "manager");
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model, HttpSession session,
            RedirectAttributes redirect) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            redirect.addFlashAttribute("error", "action requires login");
            return "redirect:/login";
        }
        User loggedUser = userService.findByUsername(username);
        if (!loggedUser.hasRole("role_manager")) {
            redirect.addFlashAttribute("error", "user not authorized");
            return "redirect:/login";
        }

        Page<Property> propertiesPaginated = propertyService.getPropertiesByPropertyManager(loggedUser.getManager(),
                page);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("countApplications", rentAppService.getByPropertyManager(loggedUser.getManager()).size());
        model.addAttribute("rented", occupationService.getByManager(loggedUser.getManager()).size());
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "manager";
    }
}