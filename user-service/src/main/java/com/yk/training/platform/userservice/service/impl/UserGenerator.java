package com.yk.training.platform.userservice.service.impl;

import com.yk.training.platform.userservice.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class UserGenerator {

    private static final String[] FIRST_NAME = {"John", "Allan", "Richard", "Robert", "Robin",
            "Alex", "Roger", "Chuck"};
    private static final String[] LAST_NAME = {"Jones", "Cristou", "Landar", "Robinson",
            "Taylor", "McGregor", "McDonald"};
    private static final LocalDate[] BIRTHDAY = {LocalDate.of(1990, 5, 7),
            LocalDate.of(1984, 11, 7),
            LocalDate.of(1999, 6, 21),
            LocalDate.of(1995, 1, 4)};

    private final Random random = new Random();
    private int index = 0;

    List<User> generateUsers(final int nUsers) {
        final List<User> users = new ArrayList<>(nUsers);
        for (int i = 0; i < nUsers; i++) {
            users.add(generateUser());
        }

        return users;
    }

    private User generateUser() {
        long currentIndex = ++index;
        return new User(currentIndex, generateFirstName(), generateLastName(), generateBirthday());
    }

    private String generateFirstName() {
        return randomArrayElement(FIRST_NAME);
    }

    private String generateLastName() {
        return randomArrayElement(LAST_NAME);
    }

    private LocalDate generateBirthday() {
        return randomArrayElement(BIRTHDAY);
    }

    private <T> T randomArrayElement(final T[] array) {
        return array[random.nextInt(array.length)];
    }
}
