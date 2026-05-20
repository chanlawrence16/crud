package com.lawrence.crud.service;

import com.lawrence.crud.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findUserById(Integer id);
}
