package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.entity.Student;

import java.util.List;

public interface UploadedWorkService {
    List<UploadedWorksInfoDto> getUploadedWorksInfo();
    List<UploadedWorksInfoDto> getUploadedWorksInfoByStudent(Student student);
}
