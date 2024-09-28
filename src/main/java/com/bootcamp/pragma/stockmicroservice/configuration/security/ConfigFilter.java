package com.bootcamp.pragma.stockmicroservice.configuration.security;

import com.bootcamp.pragma.stockmicroservice.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ConfigFilter {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/category").hasAnyAuthority(Role.ADMINISTRADOR.name())
                        .requestMatchers(HttpMethod.POST, "/brand").hasAnyAuthority(Role.ADMINISTRADOR.name())
                        .requestMatchers(HttpMethod.POST, "/article").hasAnyAuthority(Role.ADMINISTRADOR.name())
                        .requestMatchers(HttpMethod.PUT, "/article").hasAnyAuthority(Role.AUX_BODEGA.name())
                        .anyRequest().permitAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
