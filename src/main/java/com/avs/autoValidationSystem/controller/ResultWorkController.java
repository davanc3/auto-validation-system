package com.avs.autoValidationSystem.controller;

import com.avs.autoValidationSystem.model.entity.ResultWork;
import com.avs.autoValidationSystem.model.service.ResultWorkService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/result-work")
public class ResultWorkController {
    private final ResultWorkService resultWorkService;

    public ResultWorkController(ResultWorkService resultWorkService) {
        this.resultWorkService = resultWorkService;
    }

    @GetMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResultWork getResultWork(@RequestParam("studentFio") String studentFio,
                                    @RequestParam("controlWork") String controlWork) {
        return resultWorkService.getResultWorkByFioAndControlWork(studentFio, controlWork);
    }
    @PatchMapping("/{id}")
    public ResponseEntity putTeacherEvaluation(@PathVariable("id") Long id, @RequestParam("teacherEvaluation") int teacherEvaluation) {
        resultWorkService.updateTeacherEvaluation(id, teacherEvaluation);
        return ResponseEntity.ok("ВСЕ ОКЕЙ НЕ БОИСЬ");
    }
}
