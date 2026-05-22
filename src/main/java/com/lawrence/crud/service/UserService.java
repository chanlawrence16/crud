package com.lawrence.crud.service;

import com.lawrence.crud.dto.UserRequest;
import com.lawrence.crud.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> findAllUsers();

    UserResponse findUserById(Integer id);

    UserResponse createUser(UserRequest request);

    void deleteUserById(Integer id);

    UserResponse updateUser(Integer id, UserRequest request);
}
