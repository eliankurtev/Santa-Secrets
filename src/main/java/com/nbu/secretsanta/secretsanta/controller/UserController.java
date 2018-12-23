package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/login")
    public String login(User user) {
        return "ScreenHome";
    }

    @GetMapping("/admin")
    public String admin(User user) {
        return "ScreenAdmin";
    }
}
