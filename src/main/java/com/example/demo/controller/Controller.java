package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String home() {
        return ("<h1> welcome </h1>");
    }

    @GetMapping("/user")
    public String userHome() {
        return ("<h1> welcome user </h1>");
    }

    @GetMapping("/admin")
    public String adminHome() {
        return ("<h1> welcome admin </h1>");
    }
}
