package com.example.travelmemolistbe.jwt;

import com.example.travelmemolistbe.service.impl.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9eyJlbWFpbCI6ImZpcnN0QGdtYWlsLmNvbSIsImlhdCI6MTY2NzEzNDIxMiwiZXhwIjoxNjY3MTM2MDEyfQ553rFnl2KMQ0tRLusWY6EExHTGjVSbNPX8VFMSQTlQ";

    public String generateToken(CustomUserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    public String getUserNameFromJWT(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts
                    .parser()
                    .setSigningKey(JWT_SECRET)
                    .parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println();
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
