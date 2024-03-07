package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Desabilitando Ataques de CSRF, pois não estamos utilizando sessões.
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitindo todas as requisições.
        return http.build(); // Construindo a configuração de segurança.
    }

}