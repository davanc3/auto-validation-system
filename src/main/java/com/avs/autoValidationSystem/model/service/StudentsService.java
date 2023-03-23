package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;

import java.util.Set;

public interface StudentsService {
    Set<Student> getStudentsByFilter(StudentsFilterDto filterDto);
}
