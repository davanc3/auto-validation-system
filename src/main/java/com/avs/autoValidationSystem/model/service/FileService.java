package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.ArchiveFilterDto;
import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;

import java.io.IOException;

public interface FileService {
    void saveFiles(UploadWorkDto uploadWorkDto) throws IOException;
    String getArchivePathByFilter(ArchiveFilterDto filterDto) throws IOException;

}
