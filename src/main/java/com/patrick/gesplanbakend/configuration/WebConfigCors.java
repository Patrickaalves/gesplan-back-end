package com.patrick.gesplanbakend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigCors implements WebMvcConfigurer {
    /***
     * Classe criada para resolver o erro "blocked by CORS policy: Cross origin requests are only supported for
     * protocol schemes: http, data, chrome-extension, edge, https, chrome-untrusted" ou derivados
     * ***/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT","HEADER");
    }
}
