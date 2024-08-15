package com.hanna.first.springbootprj.config.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("SecurityFilterChain");
        http
                .csrf().disable()
                .headers().frameOptions().disable() // H2 Console 사용을 위한 설정
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/boards/**").hasRole("ADMIN")
                .antMatchers("/api/v1/users/**").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // 기본 인증 활성화
        /*
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
        */
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("Security config userDetailsService service");
        return customUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}