package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.entity.ResultWork;

public interface ResultWorkService {
    ResultWork getResultWorkByFioAndControlWork(String fio, String controlWorkName);

    void updateTeacherEvaluation(Long id, int teacherEvaluation);
}
