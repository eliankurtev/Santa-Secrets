package com.nbu.secretsanta.secretsanta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("ScreenHome");
        registry.addViewController("/admin").setViewName("ScreenAdmin");
        registry.addViewController("/user_not").setViewName("ScreenUserNR");
        registry.addViewController("/user").setViewName("ScreenUserR");
        registry.addViewController("/registration").setViewName("ScreenRegistration");
        registry.addViewController("/giftee").setViewName("ScreenGiftie");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
