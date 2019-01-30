package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RegistrationController {
    @PostMapping("/register")
    public String submit(@ModelAttribute ("storage")List<Hobby> theHobbies){

            System.out.println("may work .!.");
            System.out.println(theHobbies.size());

        return"ScreenRegistration ";
    }

}
