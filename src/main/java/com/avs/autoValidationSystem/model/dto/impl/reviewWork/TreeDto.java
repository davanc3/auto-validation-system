package com.avs.autoValidationSystem.model.dto.impl.reviewWork;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeDto {
    private String name;
    private String type;
    private List<TreeDto> children = new ArrayList<>();
    private String student;

    public TreeDto() {
    }

    public void pushChildren(TreeDto children) {
        this.children.add(children);
    }
}
