package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class CourseRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void findById() {
        Course course = repository.findById(10001);
        assertNotNull(course);
        assertEquals("JPA in 50 steps", course.getName());
    }

}
