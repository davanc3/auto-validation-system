package com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage;

import com.avs.autoValidationSystem.model.dto.Dto;
import lombok.Data;

@Data
public class ArchiveFilterDto implements Dto {
    private String student;
    private String group;
}
