package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow only requests from a specific origin
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:4200")  // Change this to your Angular app's URL (ensure the port is correct)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow specific HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Allow sending credentials (cookies, authorization headers)
                .maxAge(3600);  // Cache preflight response for 1 hour (optional)
    }
}
