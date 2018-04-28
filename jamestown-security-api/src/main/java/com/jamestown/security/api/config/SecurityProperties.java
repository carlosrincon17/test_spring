package com.jamestown.security.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
@Validated
@ConfigurationProperties("security-config")
public class SecurityProperties {

    @NotNull
    private String urlValidacionToken;

    public String getUrlValidacionToken() {
        return urlValidacionToken;
    }

    public void setUrlValidacionToken(String urlValidacionToken) {
        this.urlValidacionToken = urlValidacionToken;
    }
}
