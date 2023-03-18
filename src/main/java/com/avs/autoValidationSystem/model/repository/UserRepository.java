package com.avs.autoValidationSystem.model.repository;

import com.avs.autoValidationSystem.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findFirstByLogin(String login);
    User findFirstByEmail(String email);
    Optional<User> findByLogin(String login);
    User findFirstById(long id);
}
