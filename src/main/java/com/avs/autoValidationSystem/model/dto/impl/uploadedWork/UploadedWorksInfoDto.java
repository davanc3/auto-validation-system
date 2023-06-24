package com.avs.autoValidationSystem.model.dto.impl.uploadedWork;

import com.avs.autoValidationSystem.model.dto.Dto;
import lombok.Data;

import java.util.List;

@Data
public class UploadedWorksInfoDto implements Dto {
    private String fio;
    private String group;
    private String controlWork;
    private int option;
    private String task;
    private List<String> files;
    private String dateTime;

    public UploadedWorksInfoDto() {
    }
}
