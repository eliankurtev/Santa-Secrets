package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String greeting(Model model) {
        User newUser = new User();
        newUser.setIsAdmin(true);
        newUser.setUserName("patka");
        newUser.setPassword("patka");

        userService.save(newUser);
        model.addAttribute("message", "patka");
        return "user";
    }
}
