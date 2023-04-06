package com.avs.autoValidationSystem.model.dto.uploadlWorksPage;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UploadWorkDto {
    private String group;
    private String student;
    private String work;
    private int option;
    private String task;
    private MultipartFile[] files;
    public UploadWorkDto() {
    }
}
