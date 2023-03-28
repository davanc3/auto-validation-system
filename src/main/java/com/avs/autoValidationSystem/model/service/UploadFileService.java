package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;

import java.io.IOException;

public interface UploadFileService {

    void saveFiles(UploadWorkDto uploadWorkDto) throws IOException;

}
