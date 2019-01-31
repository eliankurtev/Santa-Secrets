package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.HobbyDto;
import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller() //why on different
public class RegistrationController {

    @Autowired
    private HobbyService hobbyService;

    @PostMapping("/register/submit")
    public String submit(@RequestParam("selectableHobbies") List<HobbyDto> hobbyDtos){

        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();

        List<Hobby> hobbies = new ArrayList<>();
        for (HobbyDto hobby : hobbyDtos){
            if(hobby.getIsChecked()){
                Optional<Hobby> e = hobbyService.getByName(hobby.getName());
                e.ifPresent(hobbies::add);
            }
        }

        user.setHobbies(new HashSet<>(hobbies));
        return"ScreenRegistration ";
    }

}
