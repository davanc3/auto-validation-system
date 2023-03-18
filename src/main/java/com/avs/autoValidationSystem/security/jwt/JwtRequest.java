package com.avs.autoValidationSystem.security.jwt;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtRequest {
    @NotNull
    private String login;
    @NotNull
    private String password;
}
