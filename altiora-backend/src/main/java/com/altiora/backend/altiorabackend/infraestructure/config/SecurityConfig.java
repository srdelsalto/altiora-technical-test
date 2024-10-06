package com.altiora.backend.altiorabackend.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        String moduleName = "/api/article/**";
        String moduleName2 = "/api/clients/**";
        String moduleName3 = "/api/order/**";

        http
                .csrf(AbstractHttpConfigurer::disable)  // Desactiva CSRF si no lo necesitas
                .authorizeHttpRequests(authorize -> authorize
                        // Permitir todas las solicitudes GET, POST, PUT, DELETE al módulo /tasks y Swagger
                        .requestMatchers(HttpMethod.GET, "/", moduleName, moduleName2, moduleName3, "/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.POST, moduleName, moduleName2, moduleName3, "/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.PUT, moduleName, moduleName2, moduleName3, "/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, moduleName, moduleName2, moduleName3, "/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS, moduleName, moduleName2, moduleName3, "/swagger-ui.html#/**", "/swagger-ui/index.html#/**", "/swagger-ui/**").permitAll()
                        // Permitir el acceso sin autenticación a la documentación de Swagger
                        .requestMatchers("/v3/api-docs/**", "/configuration/ui", "/swagger-resources/**",
                                "/configuration/security", "/swagger-ui.html", "/swagger-ui/index.html",
                                "/swagger-ui/**", "/webjars/**").permitAll()

                        // Todas las demás solicitudes requieren autenticación
//                        .anyRequest().authenticated()
                )
                // Establecer una política de seguridad de contenido
                .headers(headers -> headers
                        .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", "script-src 'self'"))
                );

        return http.build();
    }
}
