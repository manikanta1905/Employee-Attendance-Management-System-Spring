package com.miniproject.module.AttendanceManagementSystem.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.cors();
		http.csrf().disable();
        http.authorizeRequests()
        .antMatchers("/user/**").permitAll()
        .antMatchers("/manager/**").permitAll()
        .antMatchers("/employee/**").permitAll()
            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll();
            .and().httpBasic();
    }
	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors();http.csrf().disable();
//        http.authorizeRequests()
//        .antMatchers("/").hasAuthority("USER")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().loginPage("/login").permitAll()
//            .and()
//            .logout().permitAll();
//            .and().httpBasic();
//    }
	
	
	
}
