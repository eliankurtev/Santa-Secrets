package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    GifteeService gifteeService;

    @Autowired
    AdminService adminService;

    @PostMapping("/registration_date")
    public String getRegDate(@ModelAttribute("dateS") AdminDto date) throws Exception{
        adminService.setRegEndDate(date.getRegistrationEndDate());
        gifteeService.scheduleShuffling(date.getRegistrationEndDate());
        return "redirect:/admin";
    }

    @PostMapping("/gifts_date")
    public String getGiftDate(@ModelAttribute("gDate") AdminDto date) throws Exception{
        adminService.setGiftGivingDate(date.getGiftsDate());
        return "redirect:/admin";
    }

    @PostMapping("/price")
    public String getPrice(@ModelAttribute("price") AdminDto adminDto){
        adminService.setAdminGiftPrice(adminDto.getAdminPrice());
        return "redirect:/admin";
    }
}
