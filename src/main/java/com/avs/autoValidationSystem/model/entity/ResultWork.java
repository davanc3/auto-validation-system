package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "result_work")
@Data
public class ResultWork {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "teacher_evaluation")
    private Integer teacherEvaluation;
    @Column(name="compilation")
    private boolean compilation;
    @Column(name="byte_leak")
    private int byteLeak;
    @Column(name="allocations")
    private int аllocations;
    @OneToOne
    @JoinColumn(name = "uploaded_work_id")
    @JsonIgnore
    private UploadedWork uploadedWork;
}
