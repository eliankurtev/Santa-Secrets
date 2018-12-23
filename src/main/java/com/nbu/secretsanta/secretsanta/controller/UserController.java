package com.nbu.secretsanta.secretsanta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String greeting(Model model) {
        model.addAttribute("message", "patka");
        return "ScreenHome";
    }
}
