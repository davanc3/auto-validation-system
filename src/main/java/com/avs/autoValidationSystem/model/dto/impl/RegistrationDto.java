package com.avs.autoValidationSystem.model.dto.impl;

import com.avs.autoValidationSystem.model.dto.Dto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RegistrationDto implements Dto {
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String password;
}
