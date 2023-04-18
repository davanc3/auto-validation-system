package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.OptionsFilterDto;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.service.OptionsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/options")
public class OptionController {
    private final OptionsService optionsService;

    public OptionController(OptionsService optionsService) {
        this.optionsService = optionsService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Option> getOptionsByFilter(OptionsFilterDto filterDto) {
        return optionsService.getOptionsByFilter(filterDto);
    }
}
