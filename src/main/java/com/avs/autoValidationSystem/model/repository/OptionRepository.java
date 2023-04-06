package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.ControlWork;
import com.avs.autoValidationSystem.model.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
    Option findFirstByOptionAndControlWorks(int option, ControlWork controlWork);
}
