package com.avs.autoValidationSystem.model.dto.impl.reviewWork;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class FileTreeDto extends TreeDto {
    private long fileId;

    public FileTreeDto() {
    }
}
