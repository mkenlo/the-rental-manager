package com.mkenlo.rentalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;

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
    public void addAttributes(Model model) {
        model.addAttribute("controllerPath", "applicant");
    }

    @GetMapping("")
    public String index(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User loggedUser = userService.findByUsername(username);
        model.addAttribute("loggedUser", loggedUser);
        model.addAttribute("editUser", loggedUser);

        return "my-dashboard";
    }

    @PutMapping("/edit")
    public String editProfile(@Valid @ModelAttribute("editUser") User editUser, BindingResult result, Model model,
            HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User loggedUser = userService.findByUsername(username);
        model.addAttribute("loggedUser", loggedUser);

        if (result.hasErrors()) {
            return "my-dashboard";
        }
        userService.save(editUser);
        return "redirect:/myaccount";
    }
}
