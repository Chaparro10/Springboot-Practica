package com.platzi.platzi_pizzeria.web.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable()).
                cors(Customizer.withDefaults()).
                authorizeHttpRequests(customizeRequest ->{
            customizeRequest
                    .requestMatchers(HttpMethod.GET,"/api/**").hasAnyRole("ADMIN","CUSTOMER")
                    .requestMatchers(HttpMethod.POST,"/api/**").hasRole("ADMIN")
                    .anyRequest().authenticated();
                });
        return http.build();
    }

//    @Bean
//    public UserDetailsService memoryUser(){
//        UserDetails admin = User.builder()
//                .username("ADMIN")
//                .password(passwordEncoder().encode("123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails customer = User.builder()
//                .username("customer")
//                .password(passwordEncoder().encode("123"))
//                .roles("CUSTOMER")
//                .build();
//
//            return new InMemoryUserDetailsManager(admin,customer);
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
