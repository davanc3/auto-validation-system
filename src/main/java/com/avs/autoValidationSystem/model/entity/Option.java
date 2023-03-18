package com.avs.autoValidationSystem.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "option")
@Data
public class Option {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "option")
    private int option;

    @ManyToMany(mappedBy = "options")
    private List<ControlWork> controlWorks = new ArrayList<>();

    public Option() {
    }
}
