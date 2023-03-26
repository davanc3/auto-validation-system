package com.avs.autoValidationSystem.model.dto.uploadlWorksPage;

import lombok.Data;

@Data
public class UploadWorkResultDto {
    private boolean status;
    private String message;

    public UploadWorkResultDto() {
    }
}
