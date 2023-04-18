package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.service.UploadedWorkService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/uploaded-work")
public class UploadedWorksController {
    private final UploadedWorkService uploadedWorkService;

    public UploadedWorksController(UploadedWorkService uploadedWorkService) {
        this.uploadedWorkService = uploadedWorkService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UploadedWorksInfoDto> getAllUploadedWorkInfo() {
        return uploadedWorkService.getUploadedWorksInfo();
    }
}
