package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
public class AdminController {

    @Autowired
    GifteeService gifteeService;

    @Autowired
    AdminService adminService;

    @PostMapping("/registration_date")
    public String getDate(@ModelAttribute("date") AdminDto adminDto) {

        adminService.saveAdmin(adminDto);
        gifteeService.scheduleShuffling();

        return "redirect:ScreenAdmin";
    }
}
