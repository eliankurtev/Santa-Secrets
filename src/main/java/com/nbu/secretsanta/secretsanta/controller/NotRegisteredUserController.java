package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller("/reg")
public class NotRegisteredUserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();
        String gender;
        switch (user.getGender()){
            case 0: gender = "Man"; break;
            case 1: gender = "Woman"; break;
            case 2: gender = "Other"; break;
            default: gender = "Undefined"; break;
        }
        model.addAttribute("username", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("gender", gender);

        LinkedList<Hobby> uiSelectedHobbies = new LinkedList<>();
        LinkedList<Hobby> selectedHobbies = new LinkedList<>(userService.getHobbies(user));
        model.addAttribute("selectableHobbies",selectedHobbies );
        model.addAttribute("storage", uiSelectedHobbies);
        return "ScreenRegistration";
    }




}
