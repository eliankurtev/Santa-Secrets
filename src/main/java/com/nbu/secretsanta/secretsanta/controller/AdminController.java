package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("/admin")
@Controller
public class AdminController {
    @Autowired
    UserService userService;

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

    @PostMapping("/unregister")
    public String unregister(@RequestParam(value = "unregisterUserId", required = false) Long userId){
        User user = userService.getUserById(userId);
        userService.unregUser(user); //TODO: unregister by id
        return "redirect:/admin";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "searchString", required = false) String searchedString, Model model) {
        List<User> searchedList;
        searchedList = userService.getAllByNameContaining(searchedString);
        model.addAttribute("dateS", new AdminDto());
        model.addAttribute("gDate", new AdminDto());
        model.addAttribute("price", new AdminDto());
        model.addAttribute("searchString", searchedString);
        model.addAttribute("searchResult", searchedList);
        for (User user: searchedList) {
            System.out.println(user.getName() + "   ");
        }
        return "ScreenAdmin";
    }
}
