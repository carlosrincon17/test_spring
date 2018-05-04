package com.jamestown.security.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/")
@RestController
public class HelloWorld {

    @GetMapping
    public String helloWorld() {
        return "Api Security is works";
    }

}
