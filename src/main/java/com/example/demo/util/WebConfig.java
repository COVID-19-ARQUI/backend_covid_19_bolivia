package com.example.demo.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("PUT", "DELETE", "POST", "GET");
    }

//    @Bean
//    public RouterFunction<ServerResponse> routes(PostHandler postHandler, BlogProperties blogProperties) {
//        return route(GET("/info"), (req) -> ok().body(blogProperties))
//                .andRoute(GET("/posts"), postHandler::all)
//                .andRoute(POST("/posts"), postHandler::create)
//                .andRoute(GET("/posts/{id}"), postHandler::get)
//                .andRoute(PUT("/posts/{id}"), postHandler::update)
//                .andRoute(DELETE("/posts/{id}"), postHandler::delete);
//    }
//
//    @Bean
//    @Profile("cors")
//    CorsFilter corsConfigurationSource() {
//        var configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("http://localhost:4200", "https://mytrustedwebsite.com"));
//        var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//
//        return  new CorsFilter(source);
//    }

}