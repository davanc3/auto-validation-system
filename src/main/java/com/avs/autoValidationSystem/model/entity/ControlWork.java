package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "control_work")
@Data
public class ControlWork {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "uploaded_work",
            joinColumns = {@JoinColumn(name = "control_work_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @OrderBy("lastName asc")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "controlWorks")
    @JsonIgnore
    private List<Option> options = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "work_to_group",
            joinColumns = {@JoinColumn(name = "control_work_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    @JsonIgnore
    private List<StudyGroup> studyGroups = new ArrayList<>();

    @JsonValue
    public String getName(){
        return name;
    }

    public ControlWork() {
    }
}
