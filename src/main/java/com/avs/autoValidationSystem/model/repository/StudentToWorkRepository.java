package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudentToWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentToWorkRepository extends JpaRepository<StudentToWork, Long> {
    List<StudentToWork> findAllByStudentAndControlWorkAndOption(Student student, ControlWork controlWork, Option option);

    @Query("select s from StudentToWork as s where s.student in :students")
    List<StudentToWork> findAllByStudents(@Param("students") List<Student> students);
}
