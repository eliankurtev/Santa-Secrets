package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.DTO.AdminDto;
import com.nbu.secretsanta.secretsanta.model.User;
import com.nbu.secretsanta.secretsanta.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "ScreenHome";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        AdminDto adminDto = new AdminDto();
        model.addAttribute("dateS",adminDto);
        model.addAttribute("gDate",adminDto);
        model.addAttribute("price",adminDto);
        return "ScreenAdmin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/user")
    public String user(Model model) {
        String timer = adminService.showGiftGivingDate();
        model.addAttribute("demo2", timer);

        SecurityContext sc = SecurityContextHolder.getContext();
        User user = (User) sc.getAuthentication().getPrincipal();

        System.out.println("Logged User: " + sc.getAuthentication().getPrincipal());
        return "ScreenUserR";
    }

    @GetMapping("/user_not")
    private String notRegistered(Model model){
        String timer = adminService.showRegEndDate();
        model.addAttribute("demo", timer);
        return "ScreenUserNR";
    }

    @GetMapping("/error/403")
    public String error() {
        return "Error";
    }

}
