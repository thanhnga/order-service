package io.digital101.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operator")
public class OperatorController {
    @GetMapping("/")
    public String hello()
    {
        return "Hello Operator";
    }
}
