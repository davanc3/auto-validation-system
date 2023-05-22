package com.avs.autoValidationSystem.model.dto.impl.reviewWork;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeDto {
    private String name;
    private List<TreeDto> children = new ArrayList<>();

    public TreeDto() {
    }

    public void pushChildren(TreeDto children) {
        this.children.add(children);
    }
}
