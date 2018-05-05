package com.jamestown.security.api.service.impl;

import com.auth0.client.auth.AuthAPI;
import com.auth0.json.auth.TokenHolder;
import com.auth0.net.AuthRequest;
import com.jamestown.model.dto.Login;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.api.config.Auth0Properties;
import com.jamestown.security.api.converter.TokenHolderToSessionTokenConverter;
import com.jamestown.security.api.service.AuthServiceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceProcessorImpl implements AuthServiceProcessor {

    private AuthAPI authApi;

    @Autowired
    private Auth0Properties auth0Properties;

    @Autowired
    private TokenHolderToSessionTokenConverter tokenHolderToSessionTokenConverter;

    public SessionToken login(Login login) throws Exception {
        AuthRequest request = this.authApi.login(login.getUsername(), login.getPassword())
                .setAudience(auth0Properties.getAudience())
                .setScope(auth0Properties.getScope());
        TokenHolder holder = request.execute();
        return tokenHolderToSessionTokenConverter.convert(holder);
    }

    @Autowired
    public void configure() {
        authApi = new AuthAPI(auth0Properties.getDomain(), auth0Properties.getClientId(),
                auth0Properties.getClientSecret());
    }
}
