package com.hanuiijjang.assignment1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpController {
    @GetMapping("/")
    public String home() {
        return "login success";
    }
}
