package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.model.service.AuthService;
import com.avs.autoValidationSystem.security.jwt.JwtRequest;
import com.avs.autoValidationSystem.security.jwt.JwtResponse;
import com.avs.autoValidationSystem.security.jwt.RefreshJwtRequest;
import com.avs.autoValidationSystem.model.dto.RegistrationDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/auth")
@Slf4j
public class AuthenticationController {
    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthenticationController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest authRequest) throws AuthException {
        System.out.println(authRequest.toString());
        final JwtResponse token = authService.login(authRequest);
        return ResponseEntity.ok(token);
    }
    @PostMapping("token")
    public ResponseEntity<JwtResponse> getNewAccessToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.getAccessToken(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }
    @PostMapping("refresh")
    public ResponseEntity<JwtResponse> getNewRefreshToken(@RequestBody RefreshJwtRequest request) throws AuthException {
        final JwtResponse token = authService.refresh(request.getRefreshToken());
        return ResponseEntity.ok(token);
    }

    @PostMapping("registration")
    public ResponseEntity<String> registration(@Valid @RequestBody RegistrationDto registrationDto) {
        authService.register(modelMapper.map(registrationDto, User.class));
        return ResponseEntity.ok("User created");
    }
}
