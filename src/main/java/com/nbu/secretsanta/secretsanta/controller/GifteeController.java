package com.nbu.secretsanta.secretsanta.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class GifteeController {


    @PostMapping("/giftee")
    public String getHobbies(){


        return "ScreenGiftie";
    }
}
