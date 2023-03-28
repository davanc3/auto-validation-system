package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.service.UploadFileService;

import com.avs.autoValidationSystem.model.utils.Transliterator;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;


@Service
@Data
public class UploadFileImpl implements UploadFileService {

    @Value("${path.workUploadFile}")
    private String rootPath;

    //todo доделать добавление в бд
    @Override
    public void saveFiles(UploadWorkDto uploadWorkDto) throws IOException{
        String directorySaveFiles = rootPath +
                "/" + uploadWorkDto.getGroup() +
                "/" + uploadWorkDto.getWork() +
                "/" + uploadWorkDto.getStudent();
        String directorySaveFilesLatin = Transliterator.convertCyrToLat(directorySaveFiles);
        new File(directorySaveFilesLatin).mkdirs();
        MultipartFile[] files = uploadWorkDto.getFiles();
        for (MultipartFile multipartFile : files){
            File convFile = new File(directorySaveFilesLatin+"/"+ multipartFile.getOriginalFilename());
            multipartFile.transferTo(convFile);
        }
    }
}
