package com.tse.archintiers.photosharing.security.jwt;

import com.tse.archintiers.photosharing.model.dto.payload.JwtToken;
import com.tse.archintiers.photosharing.security.dto.UserDetailsAuth;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {
  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${shareMyPhoto.app.jwtSecret}")
  private String jwtSecret;

  @Value("${shareMyPhoto.app.jwtExpirationMs}")
  private int jwtExpirationMs;

  public JwtToken generateJwtToken(Authentication authentication) {
      Date issuedDate = new Date();
      Date expirationDate = new Date(issuedDate.getTime() + jwtExpirationMs);
      UserDetailsAuth userPrincipal = (UserDetailsAuth) authentication.getPrincipal();
      return new JwtToken(Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(issuedDate)
              .setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, jwtSecret)
              .compact(), expirationDate);
  }

  public String getUserNameFromJwtToken(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (MalformedJwtException e) {
      logger.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      logger.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      logger.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      logger.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}
