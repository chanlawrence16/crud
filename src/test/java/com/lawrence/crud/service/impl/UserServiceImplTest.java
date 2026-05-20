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
import static org.mockito.Mockito.when;

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


}
