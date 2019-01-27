package com.nbu.secretsanta.secretsanta.controller;

import com.nbu.secretsanta.secretsanta.service.interfaces.GifteeService;
import com.nbu.secretsanta.secretsanta.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    GifteeService gifteeService;

    @GetMapping("/login")
    public String login() {
        return "ScreenHome";
    }

    @GetMapping("/admin")
    public String admin() {
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
    public String user() {
        SecurityContext sc = SecurityContextHolder.getContext();
//        User user = (User) sc.getAuthentication().getPrincipal();

        System.out.println("Logged User: " + sc.getAuthentication().getPrincipal());
        return "ScreenUserR";
    }

    @GetMapping("/error/403")
    public String error() {
        return "Error";
    }

}
