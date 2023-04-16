package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;

import java.util.List;

public interface UploadedWorkService {
    List<UploadedWorksInfoDto> getUploadedWorksInfo();
}
