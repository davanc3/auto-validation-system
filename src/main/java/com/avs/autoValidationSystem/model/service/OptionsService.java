package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.OptionsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;

import java.util.List;

public interface OptionsService {
    List<Option> getOptionsByFilter(OptionsFilterDto filterDto);
    Option getOptionByOptionAndControlWork(int option, ControlWork controlWork);
}
