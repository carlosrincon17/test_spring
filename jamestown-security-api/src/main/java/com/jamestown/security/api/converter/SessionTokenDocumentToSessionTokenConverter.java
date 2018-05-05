package com.jamestown.security.api.converter;

import com.auth0.json.auth.TokenHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.api.documents.SessionTokenDocument;
import com.jamestown.security.util.JwtUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionTokenDocumentToSessionTokenConverter implements Converter<SessionTokenDocument, SessionToken> {

    @Override
    public SessionToken convert(SessionTokenDocument sessionTokenDocument) {
        ObjectMapper mapper = new ObjectMapper();
        String authorizationString = JwtUtil.getAuthorizationClaims(sessionTokenDocument.getToken());
        try {
            SessionToken sessionToken = mapper.readValue(authorizationString, SessionToken.class);
            sessionToken.setToken(sessionTokenDocument.getToken());
            return sessionToken;
        } catch (Exception e) {
            return null;
        }
    }
}
