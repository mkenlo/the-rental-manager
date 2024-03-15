package com.mkenlo.rentalmanager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mkenlo.rentalmanager.models.LoginUser;
import com.mkenlo.rentalmanager.models.User;
import com.mkenlo.rentalmanager.services.RoleService;
import com.mkenlo.rentalmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

    RoleService roleService;
    UserService userService;

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    public LoginController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String doLogin(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null)
            model.addAttribute("error", "Username or Password incorrect");
        model.addAttribute("newLogin", new LoginUser());
        return "login";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegistration(Model model) {

        model.addAttribute("newUser", new User());
        model.addAttribute("roles", roleService.getByRoleType("user"));
        return "register";
    }

    @PostMapping("/register")
    public String postRegistration(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model,
            HttpSession session) {
        userService.createUser(user, result);
        if (result.hasErrors()) {
            model.addAttribute("roles", roleService.getByRoleType("user"));
            return "register";
        }

        session.setAttribute("username", user.getUsername());
        return "redirect:/myaccount";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model,
            HttpSession session) {
        User user = userService.doLogin(loginUser, result);
        if (result.hasErrors()) {
            return "login";
        }
        session.setAttribute("username", user.getUsername());
        return "redirect:/myaccount";
    }
}
