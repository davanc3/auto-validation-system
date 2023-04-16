package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.Role;
import com.avs.autoValidationSystem.model.service.UserService;
import com.avs.autoValidationSystem.security.jwt.JwtProvider;
import com.avs.autoValidationSystem.model.dto.impl.RegistrationDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final JwtProvider jwtProvider;

    public UserController(UserService userService, ModelMapper modelMapper, JwtProvider jwtProvider) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.jwtProvider = jwtProvider;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<RegistrationDto> getUserByID(@PathVariable("id") Long id){
        return ResponseEntity.ok(modelMapper.map(userService.findById(id), RegistrationDto.class));
    }
    @GetMapping("/role")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Role>> getRole(@RequestHeader (name="Authorization") String token){
        return ResponseEntity.ok(jwtProvider.getUserByToken(token.split(" ")[1]).getRoles());
    }
}
