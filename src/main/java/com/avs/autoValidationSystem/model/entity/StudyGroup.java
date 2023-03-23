package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "study_group")
@Data
public class StudyGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "studyGroup")
    @JsonIgnore
    @OrderBy("lastName asc")
    private List<Student> students;

    @ManyToMany(mappedBy = "studyGroups")
    @JsonIgnore
    private List<ControlWork> controlWorks = new ArrayList<>();

    public StudyGroup() {
    }
}
