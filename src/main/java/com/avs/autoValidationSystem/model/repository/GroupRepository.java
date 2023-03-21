package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.StudyGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<StudyGroup, Long> {
}
