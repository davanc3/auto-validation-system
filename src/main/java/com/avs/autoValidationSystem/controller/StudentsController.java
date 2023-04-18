package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.service.StudentsService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentsController {
    private final StudentsService studentsService;

    public StudentsController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Student> getStudentsByFilter(StudentsFilterDto filterDto) {
        return studentsService.getStudentsByFilter(filterDto);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<Student> getAllStudents() {
        return studentsService.getAllStudents();
    }
}
