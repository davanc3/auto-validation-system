package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.UploadedFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadedFileRepository extends JpaRepository<UploadedFile, Long> {
}
