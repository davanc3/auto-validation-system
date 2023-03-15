package com.avs.autoValidationSystem.repository;

import com.avs.autoValidationSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByLogin(String login);
    User findFirstByEmail(String email);
    Optional<User> findByLogin(String login);
}
