package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
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
    public List<UploadedWorksInfoDto> getStudentUploadedWorkInfo(@RequestParam("student") String studentName){
        String[] studentSplit = studentName.split(" ");
        Student student;
        if (studentSplit.length > 2) {
            student = studentRepository.findFirstByLastNameAndNameAndSurname(studentSplit[0], studentSplit[1], studentSplit[2]);
        } else {
            student = studentRepository.findFirstByLastNameAndName(studentSplit[0], studentSplit[1]);
        }
        return uploadedWorkService.getUploadedWorksInfoByStudent(student);
    }
}
