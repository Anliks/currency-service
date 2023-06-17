package ru.max.processing.processingservice.decodeJwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class Decode {

    private static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public Integer getIdForToken(String jwtToken) {
        String token = jwtToken.substring(7);
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        return claims.get("id", Integer.class);
    }
}
