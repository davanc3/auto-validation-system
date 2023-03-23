package com.avs.autoValidationSystem.model.dto.uploadlWorksPage;

import lombok.Data;

@Data
public class StudentsFilterDto {
    private String group;
    private String work;

    public StudentsFilterDto() {
    }
}
