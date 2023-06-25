package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.ResultWork;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import com.avs.autoValidationSystem.model.repository.ControlWorkRepository;
import com.avs.autoValidationSystem.model.repository.ResultWorkRepository;
import com.avs.autoValidationSystem.model.repository.UploadedWorkRepository;
import com.avs.autoValidationSystem.model.service.ResultWorkService;
import com.avs.autoValidationSystem.model.service.StudentsService;
import org.springframework.stereotype.Service;

@Service
public class ResultWorkServiceImpl implements ResultWorkService {

    private final StudentsService studentsService;
    private final UploadedWorkRepository uploadedWorkRepository;
    private final ControlWorkRepository controlWorkRepository;
    private final ResultWorkRepository resultWorkRepository;

    public ResultWorkServiceImpl(StudentsService studentsService, UploadedWorkRepository uploadedWorkRepository, ControlWorkRepository controlWorkRepository, ResultWorkRepository resultWorkRepository) {
        this.studentsService = studentsService;
        this.uploadedWorkRepository = uploadedWorkRepository;
        this.controlWorkRepository = controlWorkRepository;
        this.resultWorkRepository = resultWorkRepository;
    }

    @Override
    public ResultWork getResultWorkByFioAndControlWork(String fio, String controlWorkName) {
        Student student = studentsService.getStudentByFio(fio);
        ControlWork controlWork = controlWorkRepository.findFirstByName(controlWorkName);

        if (controlWork == null) {
            throw new IllegalArgumentException("Контрольная работа не найдена");
        }

        UploadedWork uploadedWork = uploadedWorkRepository.findByStudentAndControlWork(student, controlWork);
        if (uploadedWork == null) {
            throw new IllegalArgumentException("Загруженная работа не найдена");
        }

        ResultWork resultWork = resultWorkRepository.getResultWorkByUploadedWork(uploadedWork);
        if (resultWork == null) {
            throw new IllegalArgumentException("Результаты работы не найдена");
        }

        return resultWork;
    }

    @Override
    public void updateTeacherEvaluation(Long id, int teacherEvaluation) {
        ResultWork resultWork = resultWorkRepository.findFirstById(id);
        if (resultWork == null) {
            throw new IllegalArgumentException("Результат работы не найден");
        }

        resultWork.setTeacherEvaluation(teacherEvaluation);

        resultWorkRepository.save(resultWork);
    }
}
