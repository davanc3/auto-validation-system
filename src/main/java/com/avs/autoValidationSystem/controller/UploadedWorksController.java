package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.repository.StudentRepository;
import com.avs.autoValidationSystem.model.service.UploadedWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/uploaded-work")
public class UploadedWorksController {
    private final UploadedWorkService uploadedWorkService;
    private final StudentRepository studentRepository;

    public UploadedWorksController(UploadedWorkService uploadedWorkService, StudentRepository studentRepository) {
        this.uploadedWorkService = uploadedWorkService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UploadedWorksInfoDto> getAllUploadedWorkInfo() {
        return uploadedWorkService.getUploadedWorksInfo();
    }
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UploadedWorksInfoDto> getUploadedWorkInfoByGroup(StudentsFilterDto filterDto){
        return uploadedWorkService.getUploadedWorksInfoByGroup(filterDto);
    }
}
