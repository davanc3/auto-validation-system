package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import com.avs.autoValidationSystem.model.formatter.impl.UploadedWorkFormatter;
import com.avs.autoValidationSystem.model.repository.UploadedWorkRepository;
import com.avs.autoValidationSystem.model.service.UploadedWorkService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadedWorkServiceImpl implements UploadedWorkService {
    private final UploadedWorkRepository uploadedWorkRepository;

    public UploadedWorkServiceImpl(UploadedWorkRepository uploadedWorkRepository) {
        this.uploadedWorkRepository = uploadedWorkRepository;
    }

    @Override
    public List<UploadedWorksInfoDto> getUploadedWorksInfo() {
        return new UploadedWorkFormatter().getFormattedData(uploadedWorkRepository.findAll());
    }

    @Override
    public List<UploadedWorksInfoDto> getUploadedWorksInfoByStudent(Student student) {
        return new UploadedWorkFormatter().getFormattedData(uploadedWorkRepository.findByStudent(student));
    }
}
