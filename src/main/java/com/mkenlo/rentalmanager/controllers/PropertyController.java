package com.mkenlo.rentalmanager.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
        return "property/list";
    }

    @GetMapping("/{propertyId}")
    public String detailProperty(@PathVariable("propertyId") long id, Model model, RedirectAttributes redirect,
            Principal principal) {
        Property property = propertyService.getById(id);

        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "redirect:/properties";
        }
        User loggedUser = userService.findByUsername(principal.getName());
        RentalApplication possibleRentalApplication = rentAppService
                .getByApplicantAndProperty(loggedUser.getApplicant(), property);

        model.addAttribute("possibleRentalApplication", possibleRentalApplication);
        model.addAttribute("property", property);

        return "property/detail";
    }

    /*
     * List all applications for a given property
     */
    @GetMapping("/{propertyId}/applications")
    public String getApplicationsByProperty(@PathVariable("propertyId") long propertyId, Model model,
            RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        List<RentalApplication> applications = rentAppService
                .getByProperty(property);
        model.addAttribute("property", property);
        model.addAttribute("applications", applications);
        return "property/applications-list";
    }

    @GetMapping("/{propertyId}/edit")
    public String editPropertyForm(@PathVariable("propertyId") long propertyId, Model model,
            RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        model.addAttribute("property", property);
        return "property/edit";
    }

    @PutMapping("/{propertyId}/edit")
    public String postEditProperty(@PathVariable("propertyId") long id,
            @Valid @ModelAttribute("property") Property property, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "property/edit";
        }
        propertyService.save(property);
        String controllerPath = (String) model.getAttribute("controllerPath");
        return "redirect:" + controllerPath;
    }

    @DeleteMapping("/{propertyId}/delete")
    public String deleteProperty(@PathVariable("propertyId") long id, RedirectAttributes redirect, Model model) {
        Property property = propertyService.getById(id);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        propertyService.delete(id);
        String controllerPath = (String) model.getAttribute("controllerPath");
        return "redirect:" + controllerPath;

    }

    @GetMapping("/add")
    public String addPropertyForm(Model model) {
        model.addAttribute("newProperty", new Property());
        return "property/add";
    }

    @PostMapping("/add")
    public String postAddProperty(@Valid @ModelAttribute("newProperty") Property property, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "property/add";
        }
        propertyService.save(property);
        String controllerPath = (String) model.getAttribute("controllerPath");
        return "redirect:" + controllerPath;
    }

}