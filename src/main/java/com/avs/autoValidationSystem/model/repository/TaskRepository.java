package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
