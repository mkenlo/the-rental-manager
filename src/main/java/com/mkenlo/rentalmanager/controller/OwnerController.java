package com.mkenlo.rentalmanager.controller;

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

import jakarta.servlet.http.HttpSession;
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
    public void addAttributes(Model model) {
        // @TODO add Spring Security and save user info in model here
        model.addAttribute("controllerPath", "owner");
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model, HttpSession session,
            RedirectAttributes redirect) {
        String username = (String) session.getAttribute("username");
        User loggedUser = userService.findByUsername(username);
        if (loggedUser == null) {
            redirect.addFlashAttribute("error", "action requires login");
            return "redirect:/login";
        }

        if (!loggedUser.hasRole("role_landlord")) {
            redirect.addFlashAttribute("error", "user not authorized");
            return "redirect:/login";
        }
        Landlord owner = loggedUser.getLandlord();

        Page<Property> propertiesPaginated = propertyService.getPropertiesByOwner(owner,
                page);
        model.addAttribute("countApplications", rentAppService.getByPropertyOwner(owner).size());
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("rented", occupationService.getByLandlord(owner).size());
        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "owner";
    }

    @GetMapping("/properties/add")
    public String addPropertyForm(Model model, RedirectAttributes redirect, HttpSession session) {
        String username = (String) session.getAttribute("username");
        User loggedUser = userService.findByUsername(username);
        if (loggedUser == null) {
            return "redirect:/login";
        }

        if (!loggedUser.hasRole("role_landlord")) {
            redirect.addFlashAttribute("error", "Action requires Login");
            return "redirect:/login";
        }
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("newProperty", new Property());
        return "property-add";
    }

    @PostMapping("/properties/add")
    public String postAddProperty(@Valid @ModelAttribute("newProperty") Property property, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "property-add";
        }
        propertyService.save(property);
        return "redirect:/owner";
    }

    @GetMapping("/properties/{propertyId}/edit")
    public String editPropertyForm(@PathVariable("propertyId") long propertyId, Model model,
            RedirectAttributes redirect, HttpSession session) {

        String username = (String) session.getAttribute("username");
        User loggedUser = userService.findByUsername(username);
        if (loggedUser == null) {
            return "redirect:/login";
        }
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("property", property);
        return "property-edit";
    }

    @PutMapping("/properties/{propertyId}/edit")
    public String postEditProperty(@PathVariable("propertyId") long id,
            @Valid @ModelAttribute("property") Property property, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "property-edit";
        }

        propertyService.save(property);
        return "redirect:/owner";
    }

    @DeleteMapping("/properties/{propertyId}/delete")
    public String deleteProperty(@PathVariable("propertyId") long id, Model model, RedirectAttributes redirect) {
        Property property = propertyService.getById(id);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "404";
        }
        propertyService.delete(id);

        return "redirect:/owner";

    }

    @GetMapping("/{ownerId}/applications")
    public String getRentApplications(@PathVariable("ownerId") long id, Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");

        User loggedUser = userService.findById(id);

        if (username == null || loggedUser == null) {
            return "redirect:/login";
        }

        Landlord owner = loggedUser.getLandlord();
        List<RentalApplication> applications = rentAppService.getByPropertyOwner(owner);
        model.addAttribute("applications", applications);
        model.addAttribute("loggedUser", loggedUser);
        return "rent-application-list";
    }

    @GetMapping("/{ownerId}/applications/{applicationId}")
    public String getRentApplicationsDetail(@PathVariable("ownerId") long ownerId,
            @PathVariable("applicationId") long applicationId, Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        User loggedUser = userService.findById(ownerId);

        if (username == null || loggedUser == null) {
            return "redirect:/login";
        }
        RentalApplication application = rentAppService.getById(applicationId);
        if (application == null) {
            return "404";
        }
        model.addAttribute("application", application);
        model.addAttribute("loggedUser", loggedUser);
        return "rent-application-detail";
    }

    @GetMapping("/{ownerId}/applications/{applicationId}/edit")
    public String changeStatusRentApplication(@PathVariable("ownerId") long ownerId,
            @PathVariable("applicationId") long applicationId, @RequestParam("status") boolean status, Model model,
            HttpSession session) {

        String username = (String) session.getAttribute("username");

        User loggedUser = userService.findById(ownerId);

        if (username == null || loggedUser == null) {
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
        model.addAttribute("loggedUser", loggedUser);
        return String.format("redirect:/owner/%s/applications/%s", ownerId, applicationId);
    }

    @GetMapping("/rented")
    public String getRented() {
        return "property-rented";
    }

}
