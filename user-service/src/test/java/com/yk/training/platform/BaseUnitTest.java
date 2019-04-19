package com.yk.training.platform;

import com.yk.training.platform.userservice.app.UserServiceApplication;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base class for unit tests.
 */
@SpringBootTest(classes = UserServiceApplication.class)
public class BaseUnitTest {
}
