package com.aston.intensive.gptspringsecurity.service;

import com.aston.intensive.gptspringsecurity.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Setter
@Getter
@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "jwt")
public class JwtService {

    private String secret;

    private Duration expirationAccess;

    private Duration expirationRefresh;

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(User user) {
        return buildToken(user, expirationAccess, Map.of());
    }

    public String generateRefreshToken(User user) {
        return buildToken(user, expirationRefresh, Map.of());
    }

    // способ создания токена:
    private String buildToken(User user, Duration expiration, Map<String, Object> extraClaims) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expiration.toMillis());

        return Jwts.builder()
                .claims(c -> {
                    extraClaims.forEach(c::add);
                    c.subject(user.getEmail());
                    c.issuedAt(now);
                    c.expiration(expiry);
                })
                .signWith(signInKey, Jwts.SIG.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, User user) {
        final String email = extractUsername(token);
        return email.equals(user.getEmail()) && !isTokenExpired(token);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // способ чтения клеймов:
    private <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey()).build()
                .parseSignedClaims(token)
                .getPayload();

        return resolver.apply(claims);
    }

}
