package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT student FROM Student as student join ControlWork as c on (c.id = student.controlWorks) " +
            "WHERE (:studyGroup is null or student.studyGroup = :studyGroup)")
    List<Student> findStudentsByFilter(@Param("studyGroup") StudyGroup studyGroup, @Param("controlWork") String controlWork);
}
