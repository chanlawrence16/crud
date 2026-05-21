package com.lawrence.crud.service.impl;

import com.github.javafaker.Faker;
import com.lawrence.crud.entity.User;
import com.lawrence.crud.repository.UserRepository;
import com.lawrence.crud.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceIntegrationTest {

    private final UserService userService;
    private final Faker faker = new Faker();
    private final UserRepository userRepository;

    @Autowired
    UserServiceIntegrationTest(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Test
    void shouldCreateUser() {
        //Arrange
        User user = new User();
        String username = faker.name().username();
        user.setUsername(username);
        //Act
        User result = userService.createUser(user);
        //Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(result.getUsername()).isEqualToIgnoringCase(username);
    }

    @Test
    void shouldGetUserWhenIdIsValid() {
        //Arrange
        User user = new User();
        String username = faker.name().username();
        user.setUsername(username);
        User createdUser = userService.createUser(user);
        //Act
        Integer createdUserId = createdUser.getId();
        User result = userService.findUserById(createdUserId);
        //Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getId()).isNotNull();
        Assertions.assertThat(result.getId()).isEqualTo(createdUserId);
        Assertions.assertThat(result.getUsername()).isEqualToIgnoringCase(username);
    }

    @Test
    void shouldUpdateUserUsername() {
        //Arrange
        User user = new User();
        String username = faker.name().username();
        user.setUsername(username);
        User createdUser = userService.createUser(user);
        //Act
        Integer createdUserId = createdUser.getId();
        User toBeUpdatedUser = new User();
        String newUsername = faker.name().username();
        toBeUpdatedUser.setUsername(newUsername);
        User result = userService.updateUser(createdUserId, toBeUpdatedUser);
        //Assert
        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getUsername()).isEqualToIgnoringCase(newUsername);
    }

    @Test
    void shouldDeleteUser() {
        //Arrange
        User user = new User();
        String username = faker.name().username();
        user.setUsername(username);
        User createdUser = userService.createUser(user);
        //Act
        userService.deleteUserById(createdUser.getId());
        User result = userService.findUserById(createdUser.getId());
        //Assert
        Assertions.assertThat(result).isNull();
    }

    @Test
    void shouldFindAllUsers() {
        //Arrange
        userRepository.deleteAll();
        int count = 5;
        for (int i = 0; i < count; i++) {
            User user = new User();
            String username = faker.name().username();
            user.setUsername(username);
            userService.createUser(user);
        }
        //Act
        List<User> result = userService.findAllUsers();
        //Assert
        Assertions.assertThat(result.size()).isEqualTo(count);

    }
}
