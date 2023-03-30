package com.avs.autoValidationSystem.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "control_option")
@Data
public class Option {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "control_option")
    private int option;

    @ManyToMany(mappedBy = "options")
    private List<ControlWork> controlWorks = new ArrayList<>();

    @ManyToMany(mappedBy = "options")
    private List<Task> tasks = new ArrayList<>();

    public Option() {
    }
}
