package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkResultDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FilesController {

    @PostMapping("/files")
    public UploadWorkResultDto uploadWork(@RequestBody UploadWorkDto uploadWorkDto) {

    }
}
