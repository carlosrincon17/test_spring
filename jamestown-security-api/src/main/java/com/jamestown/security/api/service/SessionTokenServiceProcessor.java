package com.jamestown.security.api.service;

import com.jamestown.commons.service.DocumentService;
import com.jamestown.model.dto.SessionToken;

public interface SessionTokenServiceProcessor extends DocumentService<SessionToken, String> {

    void delete(SessionToken sessionToken);

    SessionToken verifyToken(SessionToken sessionToken, String permission, String group);
}
