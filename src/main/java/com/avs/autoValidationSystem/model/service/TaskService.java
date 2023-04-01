package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.TasksFilterDto;
import com.avs.autoValidationSystem.model.entity.Task;

import java.util.List;

public interface TaskService {
    List<Task> getTasksByOption(TasksFilterDto tasksFilterDto);
}
