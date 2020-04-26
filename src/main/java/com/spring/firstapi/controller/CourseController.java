package com.spring.firstapi.controller;


import com.spring.firstapi.entity.Course;
import com.spring.firstapi.entity.Person;
import com.spring.firstapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourse()
    {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course findCourseById(@PathVariable int id)
    {
        return courseService.findCourseById(id);
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@Valid @RequestBody Course course, BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String,String> errors = new HashMap<>();
            for(FieldError error:result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Course>(courseService.addCourse(course),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @Valid @RequestBody Course course,BindingResult result)
    {
        if(result.hasErrors())
        {
            Map<String,String> errors = new HashMap<>();
            for(FieldError error:result.getFieldErrors())
            {
                errors.put(error.getField(),error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Course>(courseService.updateCourse(course,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id)
    {
        courseService.deleteCourse(id);
        return new ResponseEntity<String>("Record Deleted with id "+id,HttpStatus.OK);
    }
}
