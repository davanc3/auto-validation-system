package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.TasksFilterDto;
import com.avs.autoValidationSystem.model.entity.Task;
import com.avs.autoValidationSystem.model.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<Task> getTasksByOption(TasksFilterDto tasksFilterDto) {
        return taskService.getTasksByOption(tasksFilterDto);
    }
}
