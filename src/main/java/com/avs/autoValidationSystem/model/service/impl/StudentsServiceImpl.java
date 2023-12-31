package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.dto.impl.uploadlWorksPage.StudentsFilterDto;
import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.GroupRepository;
import com.avs.autoValidationSystem.model.repository.StudentRepository;
import com.avs.autoValidationSystem.model.service.StudentsService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {
    private final GroupRepository groupRepository;
    private final ControlWorkRepository controlWorkRepository;
    private final StudentRepository studentRepository;

    public StudentsServiceImpl(GroupRepository groupRepository, ControlWorkRepository controlWorkRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.controlWorkRepository = controlWorkRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentsByFilter(StudentsFilterDto filterDto) {
        StudyGroup group = null;
        ControlWork controlWork = null;
        String[] fio = {null, null, null};

        if (filterDto.getGroup() != null) {
            group = groupRepository.findFirstByName(filterDto.getGroup());
        }

        if (filterDto.getWork() != null) {
            controlWork = controlWorkRepository.findFirstByName(filterDto.getWork());
        }

        if (filterDto.getStudentFio() != null) {
            String[] fioSplit = filterDto.getStudentFio().split(" ");
            for (int i = 0; i < fioSplit.length; i++) {
                fio[i] = fioSplit[i];
            }
        }

        return studentRepository.findByFilter(
                group,
                controlWork,
                fio[0],
                fio[1],
                fio[2],
                Sort.by("lastName")
        );
    }

    @Override
    public List<String> getFioStudentsByFilter(StudentsFilterDto filterDto) {
        return studentsToStudentsFio(getStudentsByFilter(filterDto));
    }

    public Student getStudentByFio(String fio) {
        String[] fioSplit = fio.split(" ");
        Student student = null;
        if (fioSplit.length > 2) {
            student = studentRepository.findFirstByLastNameAndNameAndSurname(fioSplit[0], fioSplit[1], fioSplit[2]);
        } else if(fioSplit.length == 2) {
            student = studentRepository.findFirstByLastNameAndName(fioSplit[0], fioSplit[1]);
        }

        if (student == null) {
            throw new IllegalArgumentException("Студент с таких ФИО не существует");
        }

        return student;
    }

    private List<String> studentsToStudentsFio(List<Student> students) {
        List<String> studentFio = new ArrayList<>();
        for (Student student : students) {
            studentFio.add(student.getFio());
        }
        return studentFio;
    }
}
