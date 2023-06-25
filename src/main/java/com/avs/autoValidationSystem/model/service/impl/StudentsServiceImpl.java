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
        List<Student> students = new ArrayList<>();

        if (filterDto.getGroup() != null && filterDto.getStudentFio() == null) {
            StudyGroup studyGroup = groupRepository.findFirstByName(filterDto.getGroup());

            if (studyGroup != null) {
                students.addAll(studyGroup.getStudents());
            }
        }

        if (filterDto.getStudentFio() != null) {
            Student student = getStudentByFio(filterDto.getStudentFio());

            if (filterDto.getGroup() != null) {
                if (student.getStudyGroup().getName().equals(filterDto.getGroup())) {
                    students.add(student);
                }
            } else {
                students.add(student);
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

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("lastName"));
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
}
