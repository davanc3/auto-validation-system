package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.service.GroupService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String[] getAllGroups() {
        return groupService.getAllGroups().stream().map(StudyGroup::getName).toArray(String[]::new);
    }
}
