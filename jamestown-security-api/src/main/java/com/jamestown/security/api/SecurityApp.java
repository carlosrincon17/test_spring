package com.jamestown.security.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.jamestown.security.api.config",
        "com.jamestown.security.api.controller",
        "com.jamestown.security.api.service",
        "com.jamestown.security.api.converter"
})
@SpringBootApplication
public class SecurityApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SecurityApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class, args);
    }

}
