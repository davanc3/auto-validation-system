package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.OptionsFilterDto;
import com.avs.autoValidationSystem.model.entity.Option;

import java.util.Set;

public interface OptionsService {
    Set<Option> getOptionsByFilter(OptionsFilterDto filterDto);
}
