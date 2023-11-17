package com.example.gestinonnaryTache.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;

import java.util.Base64;
import java.util.Date;

@Service
public class JwtService {

    private static final long EXPIRATION_TIME = 864_000_000; // 10 jours en millisecondes
    private static final String SECRET_KEY;

    static {
        byte[] secretKeyBytes = new byte[64]; // 512 bits
        new SecureRandom().nextBytes(secretKeyBytes);
        SECRET_KEY = Base64.getEncoder().encodeToString(secretKeyBytes);
    }

    public String generateToken(String mail) {
        return Jwts.builder()
                .setSubject(mail)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }
}
