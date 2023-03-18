package com.avs.autoValidationSystem.model.entity;

import lombok.Data;

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
    @JoinTable(name = "student_to_work",
            joinColumns = {@JoinColumn(name = "control_work_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "option_to_work",
            joinColumns = {@JoinColumn(name = "control_work_id")},
            inverseJoinColumns = {@JoinColumn(name = "option_id")})
    private List<Option> options = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "work_to_group",
            joinColumns = {@JoinColumn(name = "control_work_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Group> groups = new ArrayList<>();

    public ControlWork() {
    }
}
