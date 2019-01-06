package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    @GetMapping("/login")
    public String login() {
        return "ScreenHome";
    }

    @GetMapping("/admin")
    public String admin() {
        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();

        System.out.println("Logged User: "+user.getName());
        return "ScreenAdmin";
    }

    @GetMapping("/user")
    public String userR() {
        return "ScreenUserR";
    }

    @GetMapping("/error/403")
    public String error() {
        return "AccessDenied";
    }
}
