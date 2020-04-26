package com.spring.firstapi.repository;

import com.spring.firstapi.entity.Course;
import com.spring.firstapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Optional<Course> findById(int id);
    void deleteById(int id);
}
