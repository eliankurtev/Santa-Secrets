package com.nbu.secretsanta.secretsanta.security;

import com.nbu.secretsanta.secretsanta.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userService;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.nbu.secretsanta.secretsanta.model.User appUser = userService.findByEmail(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);


        List<GrantedAuthority> grantList = new ArrayList<>();
        if (appUser.getIsAdmin()) {
            log.info("ADMIN");
            String s = "ROLE_ADMIN";
            GrantedAuthority authority = new SimpleGrantedAuthority(s);
            grantList.add(authority);
        } else {
            log.info("USER");
            String s = "ROLE_USER";
            GrantedAuthority authority = new SimpleGrantedAuthority(s);
            grantList.add(authority);
        }

        return new User(appUser.getEmail(),
                appUser.getPassword(), grantList);
    }

}