package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.model.Gift;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import com.nbu.secretsanta.secretsanta.service.interfaces.WishAndGiftService;
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

    @Autowired
    private WishAndGiftService wishAndGiftService;

    @GetMapping("/giftee")
    public String getHobbies(Model model) {
        setGifteeAndCategories(model);
        return "ScreenGiftee";
    }

    @GetMapping("/giftee/wish")
    public String getWish(Model model){
        setGifteeAndCategories(model);
        String message = wishAndGiftService.drowRandWish().getMessage();
        model.addAttribute("wish", message);
        return "ScreenGiftee";
    }

    @GetMapping("/giftee/gift")
    public String getGift(Model model){
        setGifteeAndCategories(model);
        Gift gift = wishAndGiftService.drowRandGift();
        model.addAttribute("wish", gift);
        return "ScreenGiftee";
    }

    private void setGifteeAndCategories(Model model) {
        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();
        String name = gifteeService.getGifteeData(user.getUserId()).getName();
        model.addAttribute("hobby", user.getHobbies());
        model.addAttribute("gifteeName", name);
    }
}
