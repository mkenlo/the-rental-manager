package com.mkenlo.rentalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/myaccount")
public class ProfileController {

    UserService userService;
    RoleService roleService;

    public ProfileController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String index(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        User loggedUser = userService.findByUsername(username);
        model.addAttribute("loggedUser", loggedUser);

        return "my-dashboard";
    }

}
