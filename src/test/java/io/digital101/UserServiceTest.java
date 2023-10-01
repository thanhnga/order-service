package io.digital101;

import io.digital101.entity.Users;
import io.digital101.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldLoginOwner() {
        Users users = userService.login("owner", "owner");
        Assertions.assertNotNull(users);
    }

    @Test
    public void shouldLoginOperator() {
        Users users = userService.login("operator", "operator");
        Assertions.assertNotNull(users);
    }
}
