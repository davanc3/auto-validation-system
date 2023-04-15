package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "uploaded_work")
@Data
public class UploadedWork {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "control_work_id")
    private ControlWork controlWork;

    @ManyToOne
    @JoinColumn(name = "control_option_id")
    private Option option;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToMany(mappedBy = "uploadedWork")
    @JsonIgnore
    private List<UploadedFile> uploadedFiles = new ArrayList<>();

    @Column(name = "load_date_time")
    private OffsetDateTime loadDateTime;

    public UploadedWork() {
    }
}
