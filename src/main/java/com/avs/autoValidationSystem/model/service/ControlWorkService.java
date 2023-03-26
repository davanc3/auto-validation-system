package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;

import java.util.Set;

public interface ControlWorkService {
    Set<ControlWork> getControlWorksByFilter(StudentsFilterDto filterDto);
}
