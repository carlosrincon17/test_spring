package com.jamestown.security.api.converter;

import com.auth0.json.auth.TokenHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.util.JwtUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TokenHolderToSessionTokenConverter implements Converter<TokenHolder, SessionToken> {

    @Override
    public SessionToken convert(TokenHolder tokenHolder) {
        ObjectMapper mapper = new ObjectMapper();
        String authorizationString = JwtUtil.getAuthorizationClaims(tokenHolder.getAccessToken());
        try {
            SessionToken sessionToken = mapper.readValue(authorizationString, SessionToken.class);
            sessionToken.setToken(tokenHolder.getAccessToken());
            return sessionToken;
        } catch (Exception e) {
            return null;
        }
    }
}
