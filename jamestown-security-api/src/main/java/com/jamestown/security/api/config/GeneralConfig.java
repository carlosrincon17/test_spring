package com.jamestown.security.api.config;

import com.jamestown.commons.service.ConverterService;
import com.jamestown.commons.service.impl.ConverterServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfig {

    @Bean
    public ConverterService converterService () {
        return new ConverterServiceImpl();
    }

}