package io.digital101.controller;

import io.digital101.entity.Users;
import io.digital101.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(name = "username")String username, @RequestParam(name = "password") String password) {
        final Users user = userService.login(username, password);
        if (user != null) {
            return ResponseEntity.ok("Login success");
        } else {
            return ResponseEntity.badRequest().body("Login Fail");
        }
    }

    @PostMapping("/admin/create")
    public ResponseEntity<?> createUser(@RequestBody Users user) {
        Users createdUser = userService.createUser(user);
        return new ResponseEntity<>("User created with ID: " + createdUser.getUserId(), HttpStatus.CREATED);
    }
}
