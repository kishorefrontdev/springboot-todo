package com.todo.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        UserDetails admin =  User.builder().username("admin").password("{noop}admin").roles("ADMIN").build();
        UserDetails employee =  User.builder().username("emp").password("{noop}123456").roles("EMPLOYEE").build();
        UserDetails mary =  User.builder().username("mary").password("{noop}123456").roles("EMPLOYEE").build();
        return new InMemoryUserDetailsManager(admin,employee,mary); 
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
   
        http.authorizeHttpRequests(configurer->
                configurer
                .requestMatchers(HttpMethod.GET,"/public/**").hasAnyRole("ADMIN","EMLOYEE")
                .requestMatchers(HttpMethod.GET,"/api/todos").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/api/users").hasRole("ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf ->csrf.disable());
        return http.build();
    }

}

