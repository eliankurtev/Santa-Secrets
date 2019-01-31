package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.HobbyDto;
import com.nbu.secretsanta.secretsanta.DTO.Wrapper;
import com.nbu.secretsanta.secretsanta.model.Hobby;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.HobbyService;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    @Autowired
    private HobbyService hobbyService;

    @Autowired
    private UserService userService;

    @PostMapping("/register/submit")
    public String submit(@ModelAttribute("wrapper") Wrapper wrapper){

        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();

        List<HobbyDto> hobbyDtoList = wrapper.getList().stream()
                .filter(h -> h.getName() != null)
                .collect(Collectors.toList());
        List<Hobby> hobbies = new ArrayList<>();
        for (HobbyDto hobby : hobbyDtoList){
                Optional<Hobby> e = hobbyService.getByName(hobby.getName());
                e.ifPresent(hobbies::add);
        }

        user.setHobbies(new HashSet<>(hobbies));
        user.setIsRegistered(true);
        userService.save(user);

        return "redirect:/login?registered";
    }

}
