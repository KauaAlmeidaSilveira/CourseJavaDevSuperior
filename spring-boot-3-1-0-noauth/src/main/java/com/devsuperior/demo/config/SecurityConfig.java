package com.devsuperior.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Desabilitando Ataques de CSRF, pois não estamos utilizando sessões.
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitindo todas as requisições.

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        // Desabilitando a proteção contra ataques de Clickjacking (X-Frame-Options).
        // O que é Clickjacking? É um ataque que consiste em enganar o usuário para que ele clique em um link
        // que não é o que ele vê, mas sim um botão ou link de um site malicioso.

        return http.build(); // Construindo a configuração de segurança.
    }

}