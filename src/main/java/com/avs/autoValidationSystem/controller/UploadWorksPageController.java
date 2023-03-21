package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.service.UploadWorksService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/uploadWorksPage")
public class UploadWorksPageController {
    private final UploadWorksService uploadWorksService;

    public UploadWorksPageController(UploadWorksService uploadWorksService) {
        this.uploadWorksService = uploadWorksService;
    }

    @GetMapping("/groups")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String[] getAllGroups()
    {
        return uploadWorksService.getAllGroups().stream().map(StudyGroup::getName).toArray(String[]::new);
    }
}
