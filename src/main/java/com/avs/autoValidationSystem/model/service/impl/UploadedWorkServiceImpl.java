package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import com.avs.autoValidationSystem.model.formatter.impl.UploadedWorkFormatter;
import com.avs.autoValidationSystem.model.repository.StudentRepository;
import com.avs.autoValidationSystem.model.repository.UploadedWorkRepository;
import com.avs.autoValidationSystem.model.service.StudentsService;
import com.avs.autoValidationSystem.model.service.UploadedWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadedWorkServiceImpl implements UploadedWorkService {
    private final UploadedWorkRepository uploadedWorkRepository;
    private final StudentsService studentsService;

    public UploadedWorkServiceImpl(UploadedWorkRepository uploadedWorkRepository, StudentsService studentsService) {
        this.uploadedWorkRepository = uploadedWorkRepository;
        this.studentsService = studentsService;
    }

    @Override
    public List<UploadedWorksInfoDto> getUploadedWorksInfo() {
        return new UploadedWorkFormatter().getFormattedData(uploadedWorkRepository.findAll());
    }

    @Override
    public List<UploadedWorksInfoDto> getUploadedWorksInfoByGroup(StudentsFilterDto studentsFilterDto) {
        return new UploadedWorkFormatter().getFormattedData(uploadedWorkRepository.findAllByStudents(studentsService.getStudentsByFilter(studentsFilterDto)));
    }
}
