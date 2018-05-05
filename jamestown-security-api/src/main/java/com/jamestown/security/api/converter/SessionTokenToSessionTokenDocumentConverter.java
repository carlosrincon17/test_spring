package com.jamestown.security.api.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.api.documents.SessionTokenDocument;
import com.jamestown.security.util.JwtUtil;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SessionTokenToSessionTokenDocumentConverter implements Converter<SessionToken, SessionTokenDocument> {

    @Override
    public SessionTokenDocument convert(SessionToken sessionToken) {
        SessionTokenDocument sessionTokenDocument = new SessionTokenDocument();
        sessionTokenDocument.setId(sessionToken.getId());
        sessionTokenDocument.setToken(sessionToken.getToken());
        return sessionTokenDocument;
    }
}
