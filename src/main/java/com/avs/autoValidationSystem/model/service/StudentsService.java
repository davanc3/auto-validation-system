package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;

import java.util.List;
import java.util.Set;

public interface StudentsService {
    List<Student> getStudentsByFilter(StudentsFilterDto filterDto);
    List<Student> getAllStudents();
}
