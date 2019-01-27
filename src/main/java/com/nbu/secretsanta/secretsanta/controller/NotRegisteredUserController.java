package com.nbu.secretsanta.secretsanta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotRegisteredUserController {
    @GetMapping("/register")
    public String register() {
        return "ScreenRegistration";
    }
}
