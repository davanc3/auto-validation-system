package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.service.ControlWorkService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ControlWorkServiceImpl implements ControlWorkService {
    private final GroupRepository groupRepository;

    public ControlWorkServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public Set<ControlWork> getControlWorksByFilter(StudentsFilterDto filterDto) {
        Set<ControlWork> controlWorks = new HashSet<>();

        if (filterDto.getGroup() != null) {
            StudyGroup studyGroup = groupRepository.findFirstByName(filterDto.getGroup());

            if (studyGroup != null) {
                controlWorks.addAll(studyGroup.getControlWorks());
            }
        }

        return controlWorks;
    }
}
