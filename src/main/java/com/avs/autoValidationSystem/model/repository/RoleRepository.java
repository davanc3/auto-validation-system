package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
