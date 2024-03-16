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

import com.mkenlo.rentalmanager.models.Property;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.PropertyService;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    UserService userService;
    PropertyService propertyService;
    RoleService roleService;

    public OwnerController(UserService userService, PropertyService propertyService, RoleService roleService) {
        this.userService = userService;
        this.propertyService = propertyService;
        this.roleService = roleService;
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
    }

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "1") int page, Model model) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        Page<Property> propertiesPaginated = propertyService.getPropertiesByOwner(loggedUser.getLandlord(),
                page);

        return addPaginationModel(page, model, propertiesPaginated);
    }

    private String addPaginationModel(int page, Model model, Page<Property> paginated) {
        List<Property> listProperties = paginated.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("properties", listProperties);
        return "owner";
    }

    @GetMapping("/add-property")
    public String addPropertyForm(Model model, RedirectAttributes redirect) {
        User loggedUser = (User) model.getAttribute("loggedUser");
        if (loggedUser == null || !loggedUser.getRoles().contains(roleService.findByName("ROLE_LANDLORD"))) {
            redirect.addFlashAttribute("error", "Action requires Login");
            return "redirect:/login";
        }
        model.addAttribute("newProperty", new Property());
        return "property-add";
    }

    @PostMapping("/add-property")
    public String postAddProperty(@Valid @ModelAttribute("newProperty") Property property, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "property-add";
        }
        propertyService.save(property);
        return "redirect:/owner";
    }

    @GetMapping("/edit-property/{propertyId}")
    public String editPropertyForm(@PathParam("propertyId") long propertyId,
            Model model,
            RedirectAttributes redirect) {
        Property property = propertyService.getById(propertyId);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "redirect:/owner";
        }
        model.addAttribute("property", property);
        return "property-edit";
    }

    @PutMapping("/edit-property/{propertyId}")
    public String postEditProperty(@PathVariable("propertyId") long id,

            @Valid @ModelAttribute("property") Property property, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "property-edit";
        }

        propertyService.save(property);
        return "redirect:/owner";
    }

    @DeleteMapping("/delete/{propertyId}")
    public String deleteProperty(@PathVariable("propertyId") long id, Model model, RedirectAttributes redirect) {
        Property property = propertyService.getById(id);
        if (property == null) {
            redirect.addAttribute("error", "Property Object Non Found");
            return "redirect:/owner";
        }
        propertyService.delete(id);

        return "redirect:/owner";

    }

}
