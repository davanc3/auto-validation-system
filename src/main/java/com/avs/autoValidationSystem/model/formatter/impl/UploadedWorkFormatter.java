package com.avs.autoValidationSystem.model.formatter.impl;

import com.avs.autoValidationSystem.model.dto.impl.uploadedWork.UploadedWorksInfoDto;
import com.avs.autoValidationSystem.model.entity.UploadedFile;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import com.avs.autoValidationSystem.model.formatter.Formatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UploadedWorkFormatter implements Formatter<UploadedWork, UploadedWorksInfoDto> {
    @Override
    public List<UploadedWorksInfoDto> getFormattedData(List<UploadedWork> uploadedWorks) {

        List<UploadedWorksInfoDto> uploadedWorksInfoDto = new ArrayList<>();

        for (UploadedWork uploadedWork: uploadedWorks) {
            uploadedWorksInfoDto.add(getFormattedData(uploadedWork));
        }

        return uploadedWorksInfoDto;
    }

    @Override
    public UploadedWorksInfoDto getFormattedData(UploadedWork uploadedWork) {
        UploadedWorksInfoDto uploadedWorkInfoDto = new UploadedWorksInfoDto();
        uploadedWorkInfoDto.setFio(uploadedWork.getStudent().getFio());
        uploadedWorkInfoDto.setControlWork(uploadedWork.getControlWork().getName());
        uploadedWorkInfoDto.setOption(uploadedWork.getOption().getOption());
        uploadedWorkInfoDto.setTask(uploadedWork.getTask().getName());
        List<String> filesName = new ArrayList<>();
        for (UploadedFile file: uploadedWork.getUploadedFiles()) {
            filesName.add(file.getFileName());
        }
        uploadedWorkInfoDto.setFiles(filesName);
        uploadedWorkInfoDto.setDateTime(
                new SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
                .format(uploadedWork.getLoadDateTime())
        );

        return uploadedWorkInfoDto;
    }
}
