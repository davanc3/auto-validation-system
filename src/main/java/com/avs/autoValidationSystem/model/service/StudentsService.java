package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;

import java.util.List;

public interface StudentsService {
    List<Student> getStudentsByFilter(StudentsFilterDto filterDto);
    Student getStudentByFio(String fio);
}
