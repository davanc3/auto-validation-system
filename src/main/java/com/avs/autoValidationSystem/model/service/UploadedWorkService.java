package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;

import java.util.List;

public interface UploadedWorkService {
    List<UploadedWorksInfoDto> getUploadedWorksInfo();
    List<UploadedWorksInfoDto> getUploadedWorksInfoByGroup(StudentsFilterDto studentsFilterDto);
}
