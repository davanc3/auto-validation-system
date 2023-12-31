package com.avs.autoValidationSystem.security.jwt;

import com.avs.autoValidationSystem.model.entity.Role;
import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.model.service.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class JwtProvider {

    private final UserService userService;

    private SecretKey jwtAccessSecret;
    private SecretKey jwtRefreshSecret;
    @Value("${jwt.token.expiredToken}")
    private long validityTokenInMinute;

    @Value("${jwt.token.expiredRefreshToken}")
    private long validityRefreshTokenInDay;

    public JwtProvider(
            @Value("${jwt.secret.access}") String jwtAccessSecret,
            @Value("${jwt.secret.refresh}") String jwtRefreshSecret,
            UserService userService) {
        this.jwtAccessSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtAccessSecret));
        this.jwtRefreshSecret = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtRefreshSecret));

        this.userService = userService;
    }

    public String createToken(String username, List<Role> roles){
        final LocalDateTime now = LocalDateTime.now();
        final Instant accessExpirationInstant = now.plusMinutes(validityTokenInMinute).atZone(ZoneId.systemDefault()).toInstant();
        final Date accessExpiration = Date.from(accessExpirationInstant);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(accessExpiration)
                .signWith(jwtAccessSecret)
                .claim("roles", getRoleNames(roles))
                .compact();
    }

    public String createRefreshToken(String username){
        final LocalDateTime now = LocalDateTime.now();
        final Instant refreshExpirationInstant = now.plusDays(validityRefreshTokenInDay).atZone(ZoneId.systemDefault()).toInstant();
        final Date refreshExpiration = Date.from(refreshExpirationInstant);
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(refreshExpiration)
                .signWith(jwtRefreshSecret)
                .compact();
    }

    public boolean validateAccessToken(String accessToken) {
        return validateToken(accessToken, jwtAccessSecret);
    }

    public boolean validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, jwtRefreshSecret);
    }

    public String getNameByToken(String accessToken){
        if(validateAccessToken(accessToken)){
            return getAccessClaims(accessToken).getSubject();
        }
        return null;
    }

    /**
     * Получени entity из токена проверенных токенов.
     * @param token токен. Имеено токен без барьера
     * @return entity user
     */
    public User getUserByToken(String token){
        if (token == null) throw new NullPointerException();
        Claims claims = getAccessClaims(token);
        return userService.findFirstByLogin(claims.getSubject());
    }
    private boolean validateToken(String token, Key secret) {
            Jwts.parserBuilder()
                    .setSigningKey(secret)
                    .build()
                    .parseClaimsJws(token);
            return true;

    }
    public Claims getAccessClaims(String token) {
        return getClaims(token, jwtAccessSecret);
    }
    public Claims getRefreshClaims(String token) {
        return getClaims(token, jwtRefreshSecret);
    }
    private Claims getClaims(String token, Key secret) {
        return Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private List<String> getRoleNames(List<Role> userRoles){
        List<String> result = new ArrayList<>();
        userRoles.forEach(role -> {
            result.add(role.getName());
        });
        return result;
    }

    public long getValidityTokenInMinute() {
        return validityTokenInMinute;
    }
}
