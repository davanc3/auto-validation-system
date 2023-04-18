package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.ArchiveFilterDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.UploadWorkDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    void uploadWork(UploadWorkDto uploadWorkDto) throws IOException;
    void uploadValidateResult(MultipartFile file) throws IOException;
    String getArchivePathByFilter(ArchiveFilterDto filterDto) throws IOException;

}
