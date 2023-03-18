package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
