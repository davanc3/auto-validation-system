package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.OptionsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.OptionRepository;
import com.avs.autoValidationSystem.model.service.OptionsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OptionsServiceImpl implements OptionsService {
    private final ControlWorkRepository controlWorkRepository;

    public OptionsServiceImpl(ControlWorkRepository controlWorkRepository) {
        this.controlWorkRepository = controlWorkRepository;
    }

    @Override
    public Set<Option> getOptionsByFilter(OptionsFilterDto filterDto) {
        Set<Option> options = new HashSet<>();

        if (filterDto.getControlWork() != null) {
            ControlWork controlWork = controlWorkRepository.findFirstByName(filterDto.getControlWork());
            if (controlWork != null) {
                options.addAll(controlWork.getOptions());
            }
        }

        return options;
    }
}