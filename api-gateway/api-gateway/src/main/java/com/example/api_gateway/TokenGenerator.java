package com.example.api_gateway;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class TokenGenerator {
    private static final String SECRET_KEY = "minhaChaveSuperSecretaParaJwt123456";

    public static void main(String[] args) {
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
        String jwt = Jwts.builder()
                .setSubject("usuario123")
                .setIssuer("meu-gateway")
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1h
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
        System.out.println("Token gerado: " + jwt);
    }
}

