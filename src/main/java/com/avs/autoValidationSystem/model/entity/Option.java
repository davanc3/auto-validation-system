package com.avs.autoValidationSystem.model.entity;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private List<ControlWork> controlWorks = new ArrayList<>();
    @ManyToMany(mappedBy = "options")
    @JsonIgnore
    private List<Task> tasks = new ArrayList<>();

    public Option() {
    }

    @JsonValue
    public int getOption(){
        return option;
    }
}
