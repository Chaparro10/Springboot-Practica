package com.platzi.platzi_pizzeria.web.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {


    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
        http.addFilterBefore(jwtFilter, BasicAuthenticationFilter.class).
                csrf(csrf->csrf.disable()).
                cors(Customizer.withDefaults()).
                sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
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
    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws  Exception{
            return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
