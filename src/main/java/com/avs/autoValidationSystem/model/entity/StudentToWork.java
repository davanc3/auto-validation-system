package com.avs.autoValidationSystem.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "student_to_work")
@Data
public class StudentToWork {
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

    @Column(name = "upload_path")
    private String uploadPath;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "load_date_time")
    private OffsetDateTime loadDateTime;

    public StudentToWork() {
    }
}
