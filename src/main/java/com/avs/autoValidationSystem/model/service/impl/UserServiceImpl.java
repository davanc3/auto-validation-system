package com.avs.autoValidationSystem.model.service.impl;

import com.avs.autoValidationSystem.model.entity.User;
import com.avs.autoValidationSystem.model.repository.UserRepository;
import com.avs.autoValidationSystem.model.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User findById(Long id){
        return userRepository.findFirstById(id);
    }
    public User findFirstByLogin(String login){
        return userRepository.findFirstByLogin(login);
    }
    public Optional<User> findByLogin(String login){
        return userRepository.findByLogin(login);
    }



}
