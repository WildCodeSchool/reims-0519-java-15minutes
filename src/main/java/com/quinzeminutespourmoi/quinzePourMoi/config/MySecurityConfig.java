package com.quinzeminutespourmoi.quinzePourMoi.config;

import com.quinzeminutespourmoi.quinzePourMoi.services.MyUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/img/**").permitAll()
                .antMatchers("/webfonts/**").permitAll()
                .antMatchers("/**.css").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/subscribe").permitAll()
                .antMatchers("/resultSurvey").authenticated()
                .antMatchers("/hypnoRegister").authenticated()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/notifications").authenticated()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .failureUrl("/loginError")
                .permitAll()
                .and()
            .logout()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
            .httpBasic()
                .and()
            .csrf()
                .disable();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
       DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
       authProvider.setUserDetailsService(userDetailsService);
       authProvider.setPasswordEncoder(passwordEncoder());
       return authProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
} 