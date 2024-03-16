package com.mkenlo.rentalmanager.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mkenlo.rentalmanager.models.Role;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/myaccount")
public class ProfileController {

    UserService userService;
    RoleService roleService;

    public ProfileController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @ModelAttribute
    public void addAttributes(Model model, Principal principal, HttpSession session) {
        User user;
        String username = "norole";
        if (principal != null) {
            username = principal.getName();
        } else if (session.getAttribute("username") != null) {
            username = (String) session.getAttribute("username");
        }
        user = userService.findByUsername(username);
        model.addAttribute("loggedUser", user);
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("roles", roleService.getByRoleType("user"));
        User user = (User) model.getAttribute("loggedUser");
        model.addAttribute("pickARole", false);
        if (user.getRoles().isEmpty()) {
            model.addAttribute("pickARole", true);
        }
        return "my-dashboard";
    }

    @PostMapping("/addRole")
    public String addFirstRole(@ModelAttribute("role") Role role, Model model, RedirectAttributes redirect) {
        if (role != null) {
            User user = (User) model.getAttribute("loggedUser");
            user.addRole(role);
            userService.save(user);
            // create entity relationships (User and Profile Type)
            userService.setUserProfile(role, user);

            redirect.addFlashAttribute("message", "Yay! you are starting your journey as a " + role.getDisplayName());
            return "redirect:" + role.getBaseUrl();
        }
        redirect.addFlashAttribute("message", "Pick a role to continue");
        return "redirect:/myaccount";

    }

}
