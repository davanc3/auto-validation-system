package com.avs.autoValidationSystem.security.jwt;

import com.avs.autoValidationSystem.entity.Role;
import com.avs.autoValidationSystem.repository.RoleRepository;
import io.jsonwebtoken.Claims;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public final class JwtUtils {
    @Autowired
    private static RoleRepository roleRepository;

    public static JwtAuthentication generate(Claims claims) {
        final JwtAuthentication jwtInfoToken = new JwtAuthentication();
        jwtInfoToken.setRoles(getRoles(claims));
        jwtInfoToken.setUsername(claims.getSubject());
        return jwtInfoToken;
    }

    private static List<Role> getRoles(Claims claims) {
        final List<String> roles = claims.get("roles", List.class);
        return roles.stream()
                .map(role -> roleRepository.findByName(role))
                .collect(Collectors.toList());
    }

}
