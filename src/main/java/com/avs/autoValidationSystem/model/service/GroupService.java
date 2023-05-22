package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.dto.impl.reviewWork.TreeDto;
import com.avs.autoValidationSystem.model.entity.StudyGroup;

import java.util.List;

public interface GroupService {
    List<StudyGroup> getAllGroups();
    List<TreeDto> getWorksTree();
}
