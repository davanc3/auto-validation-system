package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.OptionsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.OptionRepository;
import com.avs.autoValidationSystem.model.service.OptionsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionsServiceImpl implements OptionsService {
    private final ControlWorkRepository controlWorkRepository;
    private final OptionRepository optionRepository;

    public OptionsServiceImpl(ControlWorkRepository controlWorkRepository, OptionRepository optionRepository) {
        this.controlWorkRepository = controlWorkRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public List<Option> getOptionsByFilter(OptionsFilterDto filterDto) {
        List<Option> options = new ArrayList<>();

        if (filterDto.getControlWork() != null) {
            ControlWork controlWork = controlWorkRepository.findFirstByName(filterDto.getControlWork());
            if (controlWork != null) {
                options.addAll(controlWork.getOptions());
            }
        }

        return options;
    }

    public Option getOptionByOption(int option) {
        return optionRepository.findFirstByOption(option);
    }
}
