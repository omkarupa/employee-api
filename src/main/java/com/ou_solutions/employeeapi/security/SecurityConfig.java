package com.ou_solutions.employeeapi.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    public PasswordEncoder encoder;


    @Bean
    public PasswordEncoder encoder()
    {
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.authorizeHttpRequests( requests ->
                requests
                        .requestMatchers("/api/employee/sign-up/**").permitAll()
                        .requestMatchers("/api/department/saveDepartment/**").permitAll()
                        .requestMatchers("/api/job-role/saveJobRole/**").permitAll()
                        .anyRequest().authenticated());

        return http.build();
    }



}
