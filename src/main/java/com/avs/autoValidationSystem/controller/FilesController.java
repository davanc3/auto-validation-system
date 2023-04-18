package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.ArchiveFilterDto;
import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.UploadWorkDto;
import com.avs.autoValidationSystem.model.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FilesController {

    private final FileService fileService;

    public FilesController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Object> uploadWork(@ModelAttribute UploadWorkDto uploadWorkDto) throws IOException {
        fileService.uploadWork(uploadWorkDto);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/archive")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Resource> downloadArchiveByGroup(ArchiveFilterDto archiveFilterDto) throws IOException {
        ResponseEntity<Resource> response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        String archivePath = fileService.getArchivePathByFilter(archiveFilterDto);

        if (!archivePath.isEmpty()) {
            File archive = new File(archivePath);
            Resource resource = new FileSystemResource(archive);

            response = ResponseEntity.ok().header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS,"*").header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + archive.getName() + "\"") .contentType(MediaType.parseMediaType("application/zip"))
                    .body(resource);
        }

        return response;
    }

    @PostMapping("/validate-result")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> uploadValidateResult(@ModelAttribute MultipartFile file) throws IOException {
        fileService.uploadValidateResult(file);
        return ResponseEntity.ok("ok");
    }
}
