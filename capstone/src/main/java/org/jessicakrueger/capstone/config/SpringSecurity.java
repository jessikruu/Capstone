package org.jessicakrueger.capstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//^^these two pieces enable the security
public class SpringSecurity {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        //boilerplate code to protect against a hack
        http.csrf(csrf -> csrf.disable());

        //this section says to allow all pages except for the ones that are in the AntPathRequestMatcher
        //anything listed in the AntPathRequestMatcher will require the user to be authenticated

        //pages to authenticate
        http.authorizeRequests()
                .requestMatchers(
                        new AntPathRequestMatcher("/admin/**"),
                        new AntPathRequestMatcher("/user/**"),
                        new AntPathRequestMatcher("/bookClub/info"),
                        new AntPathRequestMatcher("/bookClub/create")
                ).authenticated()
                .anyRequest().permitAll();


        //where to go when the user needs to authenticate
        http.formLogin(formLogin -> formLogin
                //this is a controller method url for displaying the login page
                //this is the page that the user is redirected from when requesting a page which requiring authentication
                //spring sercurity is smart enough to remember where you were, to send you back afterwards
                .loginPage("/account/login")
                //this url is part of springsecurity, and we won't need to implement it into our controller
                //we just need to make teh form action submit to this url

                //this does not point to a specific controller that we created, this is built into spring security
                //3 things have to be completed to work:
                //1. form action needs to be set to /account/login
                //2. email field NAME needs be updated to username
                //3. password field NAME needs to be updated to password
                .loginProcessingUrl("/account/loginProcessingURL"));


        http.logout(formLogout -> formLogout
                .invalidateHttpSession(true)
                //this is the URL that will log a user out
                //this url is built into spring security
                .logoutUrl("/account/logout")
                //after spring logs the user out, then it will go to this URL
                .logoutSuccessUrl("/"));
        return http.build();

    }


    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }



}
