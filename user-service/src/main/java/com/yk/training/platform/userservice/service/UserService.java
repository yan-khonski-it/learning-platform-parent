package com.yk.training.platform.userservice.service;

import com.yk.training.platform.userservice.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface UserService {

    List<User> getUsers();

    Optional<User> getUser(Long id);
}
