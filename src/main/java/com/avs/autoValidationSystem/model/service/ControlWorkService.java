package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;

import java.util.List;
import java.util.Set;

public interface ControlWorkService {
    List<ControlWork> getControlWorksByFilter(StudentsFilterDto filterDto);
}
