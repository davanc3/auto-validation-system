package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;

import java.util.List;
import java.util.Set;

public interface UploadWorksService {
    List<StudyGroup> getAllGroups();
    Set<Student> getStudentsByFilter(StudentsFilterDto filterDto);
}
