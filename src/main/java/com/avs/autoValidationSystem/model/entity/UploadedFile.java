package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "uploaded_file")
@Data
public class UploadedFile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "upload_path")
    private String uploadPath;
    @ManyToOne
    @JoinColumn(name ="uploaded_file_id")
    @JsonIgnore
    private UploadedWork uploadedWork;
}
