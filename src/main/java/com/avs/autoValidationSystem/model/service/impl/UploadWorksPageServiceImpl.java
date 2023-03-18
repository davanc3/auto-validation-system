package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.UploadWorkPageResultDto;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.repository.OptionRepository;
import com.avs.autoValidationSystem.model.repository.StudentRepository;
import com.avs.autoValidationSystem.model.service.UploadWorksPageService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UploadWorksPageServiceImpl implements UploadWorksPageService {
    private final ControlWorkRepository controlWorkRepository;
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final OptionRepository optionRepository;

    public UploadWorksPageServiceImpl(ControlWorkRepository controlWorkRepository, StudentRepository studentRepository, GroupRepository groupRepository, OptionRepository optionRepository) {
        this.controlWorkRepository = controlWorkRepository;
        this.studentRepository = studentRepository;
        this.groupRepository = groupRepository;
        this.optionRepository = optionRepository;
    }

    @Override
    public UploadWorkPageResultDto getDataToUploadWorksPage() {
        UploadWorkPageResultDto uploadWorkPageResultDto = new UploadWorkPageResultDto();

        uploadWorkPageResultDto.setControlWorks(controlWorkRepository.findAll());
        uploadWorkPageResultDto.setStudents(studentRepository.findAll(Sort.by("lastName")));
        uploadWorkPageResultDto.setGroups(groupRepository.findAll(Sort.by("name")));
        uploadWorkPageResultDto.setOptions(optionRepository.findAll());

        return uploadWorkPageResultDto;
    }
}
