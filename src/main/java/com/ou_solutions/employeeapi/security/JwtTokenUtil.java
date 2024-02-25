package com.ou_solutions.employeeapi.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Slf4j
@Component
public class JwtTokenUtil {

    private static final long TOKEN_VALIDITY = 5 * 60 * 60 * 100;

    private Key key;

    public JwtTokenUtil()
    {
        this.key = generateKey();
    }

    public Key generateKey()
    {
        return Keys.secretKeyFor(SignatureAlgorithm.HS256);
    }

    public String generateToken(String username)
    {

        return  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY))
                .signWith(key)
                .compact();
    }

    public Claims extractAllCLiams(String token)
    {
        return Jwts.parser().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }

    public <T> T extractClaims(String token, Function<Claims,T> claimsResolver)
    {
        Claims claims = extractAllCLiams(token);
        return claimsResolver.apply(claims);
    }

    public String extractUserName(String token)
    {
        return extractClaims(token,Claims::getSubject);
    }

    public Date extractExpirationDate(String token)
    {
        return extractClaims(token,Claims::getExpiration);
    }

    public boolean isTokenExpired(String token)
    {
        return extractExpirationDate(token).before(new Date(System.currentTimeMillis()));
    }

    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        return (extractUserName(token).equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String getToken(HttpServletRequest request)
    {
        final String bearerToken = request.getHeader("Authorization");
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer "))
        {
            return bearerToken.substring(7,bearerToken.length());
        }
        return  null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SignatureException e) {
            log.info("Invalid JWT signature.");
            log.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
        }
        return false;
    }

}
