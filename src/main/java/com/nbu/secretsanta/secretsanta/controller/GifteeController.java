package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GifteeController {
    @Autowired
    private GifteeService gifteeService;

    @GetMapping("/giftee")
    public String getHobbies(Model model) {
        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();
        String name = gifteeService.getGifteeData(user.getUserId()).getName();
        model.addAttribute("gifteeName", name);
        return "ScreenGiftee";
    }

}
