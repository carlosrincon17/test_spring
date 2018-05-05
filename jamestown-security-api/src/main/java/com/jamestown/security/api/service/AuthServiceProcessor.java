package com.jamestown.security.api.service;

import com.jamestown.model.dto.Login;
import com.jamestown.model.dto.SessionToken;

public interface AuthServiceProcessor {

    SessionToken login(Login login) throws Exception;

}
