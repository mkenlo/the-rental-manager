package com.mkenlo.rentalmanager.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Landlord;
import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.RentalApplication;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyOccupationService;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RentApplicationService;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    UserService userService;
    PropertyService propertyService;
    RoleService roleService;
    RentApplicationService rentAppService;

    @Autowired
    PropertyOccupationService occupationService;

    public OwnerController(UserService userService, PropertyService propertyService, RoleService roleService,
            RentApplicationService rentAppService) {
        this.userService = userService;
        this.propertyService = propertyService;
        this.roleService = roleService;
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
    public String index(@RequestParam(defaultValue = "1") int page, Model model, Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findByUsername(username);
        Landlord owner = loggedUser.getLandlord();

        Page<Property> propertiesPaginated = propertyService.getPropertiesByOwner(owner,
                page);
        model.addAttribute("countApplications", rentAppService.getByPropertyOwner(owner).size());
        model.addAttribute("rented", occupationService.getByLandlord(owner).size());
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "owner";
    }

    @GetMapping("/properties/add")
    public String addPropertyForm(Model model) {
        model.addAttribute("newProperty", new Property());
        return "property-add";
    }

    @PostMapping("/properties/add")
    public String postAddProperty(@Valid @ModelAttribute("newProperty") Property property, BindingResult result) {
        if (result.hasErrors()) {
            return "property-add";
        }
        propertyService.save(property);
        return "redirect:/owner";
    }

    @GetMapping("/properties/{propertyId}/edit")
    public String editPropertyForm(@PathVariable("propertyId") long propertyId, Model model,
            RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        model.addAttribute("property", property);
        return "property-edit";
    }

    @PutMapping("/properties/{propertyId}/edit")
    public String postEditProperty(@PathVariable("propertyId") long id,
            @Valid @ModelAttribute("property") Property property, BindingResult result) {
        if (result.hasErrors()) {
            return "property-edit";
        }
        propertyService.save(property);
        return "redirect:/owner";
    }

    @DeleteMapping("/properties/{propertyId}/delete")
    public String deleteProperty(@PathVariable("propertyId") long id, RedirectAttributes redirect) {
        Property property = propertyService.getById(id);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        propertyService.delete(id);
        return "redirect:/owner";

    }

    @GetMapping("/{ownerId}/applications")
    public String getRentApplications(@PathVariable("ownerId") long ownerId, Model model, Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findById(ownerId);
        if (loggedUser == null || !loggedUser.getUsername().equalsIgnoreCase(username)) {
            return "redirect:/login";
        }
        Landlord owner = loggedUser.getLandlord();
        List<RentalApplication> applications = rentAppService.getByPropertyOwner(owner);
        model.addAttribute("applications", applications);
        return "rent-application-list";
    }

    @GetMapping("/{ownerId}/applications/{applicationId}")
    public String getRentApplicationsDetail(@PathVariable("ownerId") long ownerId,
            @PathVariable("applicationId") long applicationId, Model model, Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findById(ownerId);
        if (loggedUser == null || !loggedUser.getUsername().equalsIgnoreCase(username)) {
            return "redirect:/login";
        }
        RentalApplication application = rentAppService.getById(applicationId);
        if (application == null) {
            return "404";
        }
        model.addAttribute("application", application);
        return "rent-application-detail";
    }

    @GetMapping("/{ownerId}/applications/{applicationId}/edit")
    public String changeStatusRentApplication(@PathVariable("ownerId") long ownerId,
            @PathVariable("applicationId") long applicationId, @RequestParam("status") boolean status, Model model,
            Principal principal) {
        String username = principal.getName();
        User loggedUser = userService.findById(ownerId);
        if (loggedUser == null || !loggedUser.getUsername().equalsIgnoreCase(username)) {
            return "redirect:/login";
        }
        RentalApplication application = rentAppService.getById(applicationId);
        if (application == null) {
            return "404";
        }
        if (status) {
            application.setStatus("approved");
        } else
            application.setStatus("rejected");
        rentAppService.save(application);
        model.addAttribute("application", application);
        return String.format("redirect:/owner/%s/applications/%s", ownerId, applicationId);
    }

    @GetMapping("/rented")
    public String getRented() {
        return "property-rented";
    }

}
