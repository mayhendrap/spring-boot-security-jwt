package id.ravenchio.springsecurity.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private static final int EXPIRE_IN_MS = 300 * 1000;

  private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

  public String generate(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_IN_MS))
        .signWith(key)
        .compact();
  }

  public boolean validate(String token) {
    return getUsername(token) != null && isExpired(token);
  }

  public String getUsername(String token) {
    Claims claims = getClaims(token);
    return claims.getSubject();
  }

  public boolean isExpired(String token) {
    Claims claims = getClaims(token);
    return claims.getExpiration().after(new Date(System.currentTimeMillis()));
  }

  private Claims getClaims(String token) {
    return Jwts
        .parserBuilder()
        .setSigningKey(key)
        .requireIssuer(this.getUsername(token))
        .build()
        .parseClaimsJwt(token)
        .getBody();
  }

}
