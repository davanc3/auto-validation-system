package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findFirstByLastNameAndNameAndSurname(String lastName, String name, String surname);
    Student findFirstByLastNameAndName(String lastName, String name);
}
