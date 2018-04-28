package com.jamestown.security.util;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class EncryptUtils {

    public static String encodeSHA266(String stringToEncode) {
        String sha256hex = Hashing.sha256()
                .hashString(stringToEncode, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }
}
