package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.UploadedWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UploadedWorkRepository extends JpaRepository<UploadedWork, Long> {
    List<UploadedWork> findAllByStudentAndControlWorkAndOption(Student student, ControlWork controlWork, Option option);

    @Query("select s from UploadedWork as s where s.student in :students")
    List<UploadedWork> findAllByStudents(@Param("students") List<Student> students);

    List<UploadedWork> findByStudent(Student student);
}
