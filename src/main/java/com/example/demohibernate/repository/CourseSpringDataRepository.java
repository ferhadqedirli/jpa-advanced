package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Integer> {

}
