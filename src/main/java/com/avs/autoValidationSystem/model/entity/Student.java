package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
@Data
public class Student {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "study_group_id")
    private StudyGroup studyGroup;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<ControlWork> controlWorks = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<UploadedWork> uploadedWorks = new ArrayList<>();

    public Student() {
    }

    public String getFio() {
        return (lastName != null ? lastName : "" ) + " "
                + (name != null ? name : "")   + " "
                + (surname != null ? surname : "");
    }
}
