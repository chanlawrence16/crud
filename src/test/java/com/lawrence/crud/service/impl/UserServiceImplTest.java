package com.lawrence.crud.service.impl;

import com.lawrence.crud.entity.User;
import com.lawrence.crud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testFindAllUsers() {
        List<User> userList = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(userList);
        List<User> result = userService.findAllUsers();

        assertEquals(userList, result);
    }

    @Test
    void testFindUserById() {
        User user = new User();
        user.setId(1);
        user.setUsername("test");

        when(userRepository.findById(1)).thenReturn(Optional.of(user));
        User result = userService.findUserById(1);

        assertEquals("test", result.getUsername());
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setUsername("lawrence");

        when(userRepository.save(user)).thenReturn(user);
        User result = userService.createUser(user);

        assertEquals("lawrence", result.getUsername());
    }

    @Test
    void testDeleteUserById() {
        User user = new User();
        user.setId(4);

        doNothing().when(userRepository).deleteById(4);
        userService.deleteUserById(4);

        verify(userRepository).deleteById(4);
    }

    @Test
    void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(5);
        existingUser.setUsername("oldUser");

        when(userRepository.findById(5)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User newUser = new User();
        newUser.setUsername("newUser");

        User result = userService.updateUser(5, newUser);

        assertEquals("newUser", result.getUsername());

    }

}
