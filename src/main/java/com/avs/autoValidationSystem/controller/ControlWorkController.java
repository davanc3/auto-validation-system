package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.service.ControlWorkService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/control-works")
public class ControlWorkController {
    private final ControlWorkService controlWorkService;

    public ControlWorkController(ControlWorkService controlWorkService) {
        this.controlWorkService = controlWorkService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Set<ControlWork> getControlWorksByFilter(StudentsFilterDto filterDto) {
        return controlWorkService.getControlWorksByFilter(filterDto);
    }
}
