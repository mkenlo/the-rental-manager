package com.mkenlo.rentalmanager.controllers;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/properties")
public class PropertyController {

    UserService userService;
    PropertyService propertyService;
    RentApplicationService rentAppService;

    public PropertyController(UserService userService, PropertyService propertyService,
            RentApplicationService rentAppService) {
        this.userService = userService;
        this.propertyService = propertyService;
        this.rentAppService = rentAppService;
    }

    @ModelAttribute
    public void addAttributes(Model model, Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findByUsername(username);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("controllerPath", loggedUser.getRoles().get(0).getBaseUrl());
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        Page<Property> propertiesPaginated = propertyService.getAll(page);
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "property-list";
    }

    @GetMapping("/{propertyId}")
    public String detailProperty(@PathVariable("propertyId") long id, Model model, RedirectAttributes redirect) {
        Property property = propertyService.getById(id);

        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "redirect:/properties";
        }
        model.addAttribute("property", property);

        return "property-detail";
    }

    @GetMapping("/applications/{applicationId}")
    public String getApplicationDetail(@PathVariable("applicationId") long applicationId, Model model) {
        RentalApplication application = rentAppService.getById(applicationId);
        if (application == null) {
            return "404";
        }
        model.addAttribute("application", application);
        return "rent-application-detail";
    }

}