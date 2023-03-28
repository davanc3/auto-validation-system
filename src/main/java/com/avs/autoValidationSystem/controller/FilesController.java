package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.service.UploadFileService;
import com.avs.autoValidationSystem.model.service.impl.UploadFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class FilesController {

    private final UploadFileService uploadFileService;

    public FilesController(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @PostMapping("/files")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity uploadWork(@ModelAttribute UploadWorkDto uploadWorkDto) throws IOException {
        System.out.println(uploadWorkDto.getFiles());
        uploadFileService.saveFiles(uploadWorkDto);
        return ResponseEntity.ok("ok");
    }
}
