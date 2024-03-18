package com.mkenlo.rentalmanager.controller;

import java.security.Principal;
import java.util.List;

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

    public OwnerController(UserService userService, PropertyService propertyService, RoleService roleService,
            RentApplicationService rentAppService) {
        this.userService = userService;
        this.propertyService = propertyService;
        this.roleService = roleService;
        this.rentAppService = rentAppService;
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
        model.addAttribute("controllerPath", "owner");
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        Page<Property> propertiesPaginated = propertyService.getPropertiesByOwner(loggedUser.getLandlord(),
                page);

        propertyService.addPaginationModel(page, model, propertiesPaginated);
        return "owner";
    }

    @GetMapping("/properties/add")
    public String addPropertyForm(Model model, RedirectAttributes redirect) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        if (loggedUser == null || !loggedUser.getRoles().contains(roleService.findByName("ROLE_LANDLORD"))) {
            redirect.addFlashAttribute("error", "Action requires Login");
            return "redirect:/login";
        }
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
            RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "redirect:/owner";
        }
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
            return "redirect:/owner";
        }
        propertyService.delete(id);

        return "redirect:/owner";

    }

    @GetMapping("/properties/applications")
    public String getRentApplications(Model model) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        Landlord owner = loggedUser.getLandlord();
        List<RentalApplication> applications = rentAppService.getByPropertyOwner(owner);
        model.addAttribute("applications", applications);
        return "rent-application-list";
    }

    @GetMapping("/properties/applications/{applicationID}")
    public String getRentApplicationsDetail() {
        return "rent-application-detail";
    }

}
