package com.nbu.secretsanta.secretsanta.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthSuccessHandler   extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        // Get the role of logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();

        String targetUrl = "";
        if(role.contains("ADMIN")) {
            targetUrl = "/admin";
        } else if(role.contains("USER")) {
            //TODO: Make a check if the registration date is ended
            targetUrl = "/user";
        } else if(role.contains("ROLE_NOT_REGISTERED")){
            targetUrl = "/user_not";
        }
        logger.info(targetUrl);
        return targetUrl;
    }
}
