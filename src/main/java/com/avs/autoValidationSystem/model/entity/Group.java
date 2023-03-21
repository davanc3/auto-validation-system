package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
@Data
public class Group {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "group")
    @JsonIgnore
    private List<Student> students;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private List<ControlWork> controlWorks = new ArrayList<>();

    public Group() {
    }
}