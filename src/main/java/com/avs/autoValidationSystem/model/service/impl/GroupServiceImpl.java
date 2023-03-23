package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.service.GroupService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<StudyGroup> getAllGroups() {
        return groupRepository.findAll(Sort.by("name"));
    }
}
