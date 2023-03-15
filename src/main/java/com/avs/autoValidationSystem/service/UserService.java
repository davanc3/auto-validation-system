package com.avs.autoValidationSystem.service;

import com.avs.autoValidationSystem.entity.User;
import com.avs.autoValidationSystem.repository.RoleRepository;
import com.avs.autoValidationSystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public User findFirstByLogin(String login){
        return userRepository.findFirstByLogin(login);
    }
    public User findFirstByEmail(String email){
        return userRepository.findFirstByEmail(email);
    }
    public Optional<User> findByLogin(String login){
        return userRepository.findByLogin(login);
    }



}
