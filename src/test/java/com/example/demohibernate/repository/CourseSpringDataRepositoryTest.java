package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import com.example.demohibernate.entity.Review;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class CourseSpringDataRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Autowired
    EntityManager em;

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
}
