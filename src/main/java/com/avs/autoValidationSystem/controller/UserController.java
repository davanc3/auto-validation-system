package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.model.service.UserService;
import com.avs.autoValidationSystem.security.jwt.JwtProvider;
import com.avs.autoValidationSystem.model.service.impl.UserServiceImpl;
import com.avs.autoValidationSystem.model.dto.RegistrationDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
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
    public ResponseEntity<RegistrationDto> getOne(@PathVariable("id") Long id){
        Optional<User> userEntity = userService.findById(id);
        return ResponseEntity.ok(modelMapper.map(userEntity.get(), RegistrationDto.class));
    }
}
