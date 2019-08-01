package com.quinzeminutespourmoi.quinzePourMoi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
 
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user1").password("{noop}user1Pass").roles("USER")
            .and()
            .withUser("admin1").password("{noop}admin1Pass").roles("ADMIN");
    }
 
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/anonymous*").anonymous()
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
             
            .and()
            .formLogin()
            .loginPage("/login.html")
            .loginProcessingUrl("/login")
            .failureUrl("/login.html?error=true")
             
            .and()
            .logout().deleteCookies("JSESSIONID")
             
            .and()
            .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400); // for one day in second            ;
    }
}