package com.spring.firstapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping
    public String welcome()
    {
        return "Api can be accessed using the following URls: " +
                "\n" + "Get all courses /course" +"\n" + "Get course by ID course/{id}" + "\n"
                + "Add Course /course" + "\n"+"Update Course course/{id}" + "\n" + "Delete Course course/{id}";
    }
}
