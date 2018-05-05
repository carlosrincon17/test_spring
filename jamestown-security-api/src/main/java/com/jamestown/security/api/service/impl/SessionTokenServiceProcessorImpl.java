package com.jamestown.security.api.service.impl;

import com.jamestown.commons.service.impl.DocumentServiceImpl;
import com.jamestown.model.dto.SessionToken;
import com.jamestown.security.api.dao.SessionTokenDao;
import com.jamestown.security.api.documents.SessionTokenDocument;
import com.jamestown.security.api.service.SessionTokenServiceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionTokenServiceProcessorImpl extends DocumentServiceImpl<SessionToken, SessionTokenDocument, String> implements SessionTokenServiceProcessor {


    @Autowired
    private SessionTokenDao dao;

    @Override
    protected SessionTokenDao getDao() {
        return dao;
    }

    @Override
    public void delete(SessionToken sessionToken) {
        SessionTokenDocument sessionTokenDocument = this.getDao().getByToken(sessionToken.getToken());
        this.getDao().delete(sessionTokenDocument);
    }

    @Override
    public SessionToken verifyToken(SessionToken sessionToken, String permission, String group) {
        SessionTokenDocument sessionTokenDocument = this.getDao().getByToken(sessionToken.getToken());
        SessionToken sessionTokenSaved = this.converterService.convertTo(sessionTokenDocument, SessionToken.class);
        if (sessionTokenSaved.getPermissions().contains(permission) && sessionTokenSaved.getGroups().contains(group)) {
            return sessionTokenSaved;
        }
        return null;
    }
}
