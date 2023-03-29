package com.avs.autoValidationSystem.security.jwt;

import com.avs.autoValidationSystem.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class JwtResponse {
    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
    private List<Role> role;
}
