package com.avs.autoValidationSystem.model.service;

import com.avs.autoValidationSystem.model.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    User findFirstByLogin(String login);
    User findFirstByEmail(String email);
    Optional<User> findByLogin(String login);
}
