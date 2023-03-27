package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.service.UploadFileService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;


@Service
@Data
public class UploadFileImpl implements UploadFileService {

    @Value("${path.workUploadFile}")
    private String rootPath;

    public UploadFileImpl(){
    }
    //todo доделать добавление в бд
    @Override
    public void saveFiles(UploadWorkDto uploadWorkDto) throws IOException {
        String directorySaveFiles = rootPath +
                "/" + uploadWorkDto.getGroup() +
                "/" + uploadWorkDto.getWork() +
                "/" + uploadWorkDto.getStudent();
        if(!new File(directorySaveFiles).exists()) {
            new File(directorySaveFiles).mkdir();
        }
        MultipartFile[] files = uploadWorkDto.getFiles();
        for (MultipartFile multipartFile : files){
            File convFile = new File(directorySaveFiles+"/"+ multipartFile.getOriginalFilename());
            multipartFile.transferTo(convFile);
        }
    }
}
