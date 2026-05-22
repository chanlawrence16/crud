package com.lawrence.crud.service.impl;

import com.lawrence.crud.dto.UserRequest;
import com.lawrence.crud.dto.UserResponse;
import com.lawrence.crud.entity.User;
import com.lawrence.crud.mapper.UserMapper;
import com.lawrence.crud.repository.UserRepository;
import com.lawrence.crud.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = userMapper.fromEntitiesToReponses(users);
        return userResponses;
    }

    @Override
    @Transactional
    public UserResponse findUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        UserResponse userResponse = userMapper.fromEntityToResponse(user);
        return userResponse;
    }

    @Override
    @Transactional
    public UserResponse createUser(UserRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setCreatedDate(LocalDateTime.now());
        User savedUser = userRepository.save(newUser);
        UserResponse userResponse = userMapper.fromEntityToResponse(savedUser);
        return userResponse;
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserResponse updateUser(Integer id, UserRequest request) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return null;
        }
        User foundUser = optionalUser.get();
        foundUser.setUsername(request.getUsername());
        User updatedUser = userRepository.save(foundUser);
        UserResponse userResponse = userMapper.fromEntityToResponse(updatedUser);
        return userResponse;
    }
}
