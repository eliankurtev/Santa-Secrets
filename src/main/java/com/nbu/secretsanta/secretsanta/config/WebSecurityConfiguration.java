package com.nbu.secretsanta.secretsanta.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("dev")
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfiguration(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Autowired
    private DataSource dataSource;

    private final String USERS_QUERY = "select email, password, is_enabled from user where email=? ";
    private final String ROLES_QUERY = "SELECT user.email as username, role.name as role \n" +
            "        FROM user \n" +
            "        INNER JOIN user_role ON user.id = user_role.user_id \n" +
            "        INNER JOIN role ON user_role.role_id = role.id\n" +
            "        WHERE user.email = ?  ";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
        ;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .passwordParameter("loginPassword")
                .usernameParameter("loginUsername")
                .successForwardUrl("/admin")
                .defaultSuccessUrl("/admin", true)
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers(
                        "/",
                        "/js/**",
                        "/css/**",
                        "/images/**",
                        "/node_modules/**",
                        "/other/**").permitAll()
                .antMatchers("/login").authenticated()
                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .userDetailsService(this.userDetailsService);
    }

//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
//        db.setDataSource(dataSource);
//
//        return db;
//    }
}
