package com.spring.firstapi.service;


import com.spring.firstapi.entity.Course;
import com.spring.firstapi.entity.Person;
import com.spring.firstapi.exception.NotFoundException;
import com.spring.firstapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course)
    {
     courseRepository.save(course);
     return course;
    }

    public List<Course> getAllCourses()
    {
        return courseRepository.findAll();
    }

    public Course findCourseById(int id)
    {

        Optional<Course> course=courseRepository.findById(id);
        if(!course.isPresent())
        {
            throw new NotFoundException("Course with id "+id+" does not exists!");
        }

        return course.get();
    }

    public Course updateCourse(Course course, int id)
    {

        Optional<Course> Opcourse=courseRepository.findById(id);
        if(!Opcourse.isPresent())
        {
            throw new NotFoundException("Course with id "+id+" does not exists!");
        }
        course.setId(id);
        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(int id)
    {
        Optional<Course> course=courseRepository.findById(id);
        if(!course.isPresent())
        {
            throw new NotFoundException("Course with id "+id+" does not exists!");
        }
        courseRepository.delete(course.get());
    }
}
