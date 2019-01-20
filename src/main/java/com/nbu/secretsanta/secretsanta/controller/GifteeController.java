package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.Hobby;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class GifteeController {


    @PostMapping("/register_user")
    public String getHobbies(@ModelAttribute List<Hobby> hobbies){
        for(Hobby hobby : hobbies){

        }

        return "ScreenUserR";
    }
}
