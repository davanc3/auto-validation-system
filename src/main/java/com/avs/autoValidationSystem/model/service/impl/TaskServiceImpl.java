package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.TasksFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.entity.Task;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.service.ControlWorkService;
import com.avs.autoValidationSystem.model.service.OptionsService;
import com.avs.autoValidationSystem.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final OptionsService optionsService;
    private final ControlWorkRepository controlWorkRepository;

    public TaskServiceImpl(OptionsService optionsService, ControlWorkRepository controlWorkRepository) {
        this.optionsService = optionsService;
        this.controlWorkRepository = controlWorkRepository;
    }

    @Override
    public List<Task> getTasksByOption(TasksFilterDto tasksFilterDto) {
        List<Task> tasks = new ArrayList<>();
        if (tasksFilterDto.getControlWork() != null) {
            ControlWork controlWork = controlWorkRepository.findFirstByName(tasksFilterDto.getControlWork());
            if (tasksFilterDto.getOption() != null && controlWork != null) {
                Option option = optionsService.getOptionByOptionAndControlWork(tasksFilterDto.getOption(), controlWork);
                if (option != null) {
                    tasks.addAll(option.getTasks());
                }
            }
        }
        return tasks;
    }
}
