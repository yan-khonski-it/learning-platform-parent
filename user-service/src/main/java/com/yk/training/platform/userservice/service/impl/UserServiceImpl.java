package com.yk.training.platform.userservice.service.impl;

import com.yk.training.platform.userservice.model.User;
import com.yk.training.platform.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final int N_USERS = 10;

    private final List<User> users;

    public UserServiceImpl() {
        final UserGenerator userGenerator = new UserGenerator();
        users = userGenerator.generateUsers(N_USERS);
    }

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUser(Long id) {
        return isIdValid(id) ?
                Optional.of(users.get(id.intValue())) :
                Optional.empty();
    }

    private boolean isIdValid(final Long id) {
        return id != null && id >= 0 && id < N_USERS;
    }
}
