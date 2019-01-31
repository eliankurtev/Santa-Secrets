package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.HobbyDto;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NotRegisteredUserController {

    @Autowired
    private HobbyService hobbyService;

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

        List<HobbyDto> allHobbies = hobbyService.getHobbyDtos();
        model.addAttribute("selectableHobbies", allHobbies );

        return "ScreenRegistration";
    }



}
