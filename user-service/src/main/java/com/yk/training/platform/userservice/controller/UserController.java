package com.yk.training.platform.userservice.controller;

import com.yk.training.platform.userservice.configuration.UrlConstants;
import com.yk.training.platform.userservice.model.User;
import com.yk.training.platform.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = UrlConstants.API_USER_SERVICE_USER, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping(UrlConstants.URI_USER_ID)
    public ResponseEntity<User> getUser(@PathVariable(UrlConstants.USER_ID) final Long id) {
        return ResponseEntity.of(userService.getUser(id));
    }
}
