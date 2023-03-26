package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.service.StudentsService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final GroupRepository groupRepository;
    private final ControlWorkRepository controlWorkRepository;

    public StudentsServiceImpl(GroupRepository groupRepository, ControlWorkRepository controlWorkRepository) {
        this.groupRepository = groupRepository;
        this.controlWorkRepository = controlWorkRepository;
    }

    @Override
    public Set<Student> getStudentsByFilter(StudentsFilterDto filterDto) {
        Set<Student> students = new HashSet<>();

        if (filterDto.getGroup() != null) {
            StudyGroup studyGroup = groupRepository.findFirstByName(filterDto.getGroup());

            if (studyGroup != null) {
                students.addAll(studyGroup.getStudents());
            }
        }

        if (filterDto.getWork() != null) {
            ControlWork controlWork = controlWorkRepository.findFirstByName(filterDto.getWork());

            if (controlWork != null) {
                students.addAll(controlWork.getStudents());
            }
        }

        return students;
    }
}
