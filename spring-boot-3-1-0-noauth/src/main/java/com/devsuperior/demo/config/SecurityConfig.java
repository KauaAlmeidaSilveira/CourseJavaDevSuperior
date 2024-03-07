package com.devsuperior.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
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
	@Profile("test")
	@Order(1)
	public SecurityFilterChain h2SecurityFilterChain(HttpSecurity http) throws Exception {
		http.securityMatcher(PathRequest.toH2Console()).csrf(csrf -> csrf.disable())
				.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
        // Desabilitando a proteção contra ataques de Clickjacking (X-Frame-Options).
        // O que é Clickjacking? É um ataque que consiste em enganar o usuário para que ele clique em um link
        // que não é o que ele vê, mas sim um botão ou link de um site malicioso.
		return http.build();
	}

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()); // Desabilitando Ataques de CSRF, pois não estamos utilizando sessões.
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()); // Permitindo todas as requisições.
        return http.build(); // Construindo a configuração de segurança.
    }



}