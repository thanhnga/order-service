package io.digital101.controller;

import io.digital101.entity.Users;
import io.digital101.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class UserController {
    @GetMapping("/hello")
    public String helloAdmin()
    {
       // return ResponseEntity.ok("Hello Admin");
        return "Hello Admin";
    }
}
