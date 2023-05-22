package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.dto.impl.reviewWork.TreeDto;
import com.avs.autoValidationSystem.model.service.GroupService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/review-work")
public class WorkReviewController {

    private final GroupService groupService;

    public WorkReviewController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/tree")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<TreeDto> getWorksTree() {
        return groupService.getWorksTree();
    }

}
