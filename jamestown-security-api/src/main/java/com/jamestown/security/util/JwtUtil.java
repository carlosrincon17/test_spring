package com.jamestown.security.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {

    private static String AUTORIZATION_CLAIM = "scope";

    public static String getAuthorizationClaims(String jwtToken) {
        DecodedJWT jwt = JWT.decode(jwtToken);
        return jwt.getClaim(AUTORIZATION_CLAIM).asString();
    }
}
