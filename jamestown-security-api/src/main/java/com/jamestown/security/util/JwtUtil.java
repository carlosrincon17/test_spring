package com.jamestown.security.util;

import com.jamestown.model.dto.Rol;
import com.jamestown.model.dto.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {

    public static String createJwt(User user, List<Rol> roles) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("test");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        String rolesClaims = roles.stream().map((Rol rol) -> rol.getName() + " ").reduce("", String::concat);
        JwtBuilder builder = Jwts.builder().setId(user.getId())
                .setIssuedAt(new Date())
                .claim("roles", rolesClaims)
                .claim("user", user.getId())
                .signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }
}
