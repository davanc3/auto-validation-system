package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.TasksFilterDto;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.entity.Task;
import com.avs.autoValidationSystem.model.service.OptionsService;
import com.avs.autoValidationSystem.model.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final OptionsService optionsService;

    public TaskServiceImpl(OptionsService optionsService) {
        this.optionsService = optionsService;
    }

    @Override
    public List<Task> getTasksByOption(TasksFilterDto tasksFilterDto) {
        List<Task> tasks = new ArrayList<>();

        if (tasksFilterDto.getOption() != null) {
            Option option = optionsService.getOptionByOption(tasksFilterDto.getOption());
            if (option != null) {
                tasks.addAll(option.getTasks());
            }
        }

        return tasks;
    }
}
