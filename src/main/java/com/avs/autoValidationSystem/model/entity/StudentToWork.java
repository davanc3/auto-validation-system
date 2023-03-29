package com.avs.autoValidationSystem.model.entity;

import lombok.Data;

import javax.persistence.*;

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

    public StudentToWork() {
    }
}
