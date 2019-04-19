package com.yk.training.platform.userservice.service.impl;

import com.yk.training.platform.BaseUnitTest;
import com.yk.training.platform.TestHelper;
import com.yk.training.platform.userservice.model.User;
import com.yk.training.platform.userservice.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest extends BaseUnitTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldGetUser() {
        User user = userService.getUser(1L).orElseThrow();
        TestHelper.assertUserIsValid(user);
    }

    @Test
    public void shouldEmptyIdNull() {
        Optional<User> user = userService.getUser(null);
        assertTrue(user.isEmpty());
    }

    @Test
    public void shouldEmptyIdNotFound() {
        Optional<User> user = userService.getUser(33L);
        assertTrue(user.isEmpty());
    }

    @Test
    public void shouldGetUsers() {
        List<User> users = userService.getUsers();
        assertTrue(users != null && !users.isEmpty());
        users.forEach(TestHelper::assertUserIsValid);
    }


}