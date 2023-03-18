package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.RegistrationDto;
import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.security.jwt.JwtAuthentication;
import com.avs.autoValidationSystem.security.jwt.JwtRequest;
import com.avs.autoValidationSystem.security.jwt.JwtResponse;

import javax.security.auth.message.AuthException;

public interface AuthService {
    JwtResponse login(JwtRequest authRequest) throws AuthException;
    JwtResponse getAccessToken(String refreshToken) throws AuthException;
    JwtResponse refresh(String refreshToken) throws AuthException;
    JwtAuthentication getAuthInfo();
    User register(User user);
}
