package com.colak.springtutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    // http://localhost:8080/api/demo
    @GetMapping("#{apiCache.getApi('DEMO-API')}")
    public String demo() {
        return "Hello from Spring Boot!";
    }
}
