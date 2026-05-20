package com.lawrence.crud.service.impl;

import com.lawrence.crud.entity.User;
import com.lawrence.crud.repository.UserRepository;
import com.lawrence.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        user.setCreatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
