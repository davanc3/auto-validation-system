package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Student;
import com.avs.autoValidationSystem.model.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findFirstByLastNameAndNameAndSurname(String lastName, String name, String surname);
    Student findFirstByLastNameAndName(String lastName, String name);

    @Query("from Student as s where (:group is null or s.studyGroup = :group) " +
            "and (:controlWork is null or :controlWork member of s.controlWorks) " +
            "and (:lastname is null or s.lastName = :lastname)" +
            "and (:name is null or s.name = :name)" +
            "and (:surname is null or s.surname = :surname)")
    List<Student> findByFilter(@Param("group") StudyGroup studyGroup,
                               @Param("controlWork") ControlWork controlWork,
                               @Param("lastname") String lastname,
                               @Param("name") String name,
                               @Param("surname") String surname);
}
