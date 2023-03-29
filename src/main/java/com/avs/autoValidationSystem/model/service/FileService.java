package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.ArchiveFilterDto;
import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudentToWork;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface FileService {
    void saveFiles(UploadWorkDto uploadWorkDto) throws IOException;
    String getArchivePathByFilter(ArchiveFilterDto filterDto) throws IOException;

}
