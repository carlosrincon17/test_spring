package com.jamestown.security.api.service.impl;

import com.auth0.client.auth.AuthAPI;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Auth0ServiceImpl {

    private AuthAPI authApi;

    public Auth0ServiceImpl() {
        this.authApi = new AuthAPI("{YOUR_DOMAIN}", "{YOUR_CLIENT_ID}", "{YOUR_CLIENT_SECRET}");
    }


}
