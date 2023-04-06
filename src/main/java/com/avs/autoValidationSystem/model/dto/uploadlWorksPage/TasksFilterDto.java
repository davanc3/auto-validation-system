package com.avs.autoValidationSystem.model.dto.uploadlWorksPage;

import lombok.Data;

@Data
public class TasksFilterDto {
    private Integer option;
    private String controlWork;

    public TasksFilterDto() {
    }
}
