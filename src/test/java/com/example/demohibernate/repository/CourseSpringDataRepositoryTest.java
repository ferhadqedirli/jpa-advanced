package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class CourseSpringDataRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    void findById_coursePresent() {
        Optional<Course> courseOptional = repository.findById(10001);
        assertTrue(courseOptional.isPresent());
    }

    @Test
    void findById_courseNotPresent() {
        Optional<Course> courseOptional = repository.findById(20001);
        assertFalse(courseOptional.isPresent());
    }

    @Test
    void playingAroundWithSpringDataRepository() {
        Course course = repository.save(new Course("Microservices in 100 Steps"));
        course.setName("Microservices in 100 Steps - Updated");
        repository.save(course);

        logger.info("Courses -> {}", repository.findAll());
    }

    @Test
    void sort() {
        Sort sort = Sort.by("name").descending();

        logger.info("Sorted Courses -> {}", repository.findAll(sort));
    }

    @Test
    void pagination() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Course>  firstPage = repository.findAll(pageRequest);
        logger.info("First Page -> {}", firstPage.getContent());

        Pageable secondPageable = firstPage.nextPageable();
        Page<Course> secondPage = repository.findAll(secondPageable);
        logger.info("Second Page -> {}", secondPage.getContent());
    }
}
