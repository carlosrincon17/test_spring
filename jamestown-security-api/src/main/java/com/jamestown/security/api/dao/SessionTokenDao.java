package com.jamestown.security.api.dao;

import com.jamestown.security.api.documents.SessionTokenDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionTokenDao extends MongoRepository<SessionTokenDocument, String> {

    SessionTokenDocument getByToken(String token);
    
}
