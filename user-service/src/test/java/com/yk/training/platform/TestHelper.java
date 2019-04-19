package com.yk.training.platform;

import com.yk.training.platform.userservice.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHelper {

    public static void assertUserIsValid(final User user) {
        assertNotNull(user);
        assertNotNull(user.getId());
        assertNotNull(user.getFirstName());
        assertNotNull(user.getLastName());
        assertNotNull(user.getBirthday());
    }

    public static void assertUsersAreValid(final List<User> users) {
        assertTrue(users != null && !users.isEmpty());
        users.forEach(TestHelper::assertUserIsValid);
    }
}
