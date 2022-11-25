package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class CourseRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseRepository repository;

    @Test
    void findById_basic() {
        Course course = repository.findById(10001);
        assertNotNull(course);
        assertEquals("JPA in 50 steps", course.getName());
    }

    @Test
    @DirtiesContext//reset data after testing
    void deleteById_basic() {
        repository.deleteById(10001);
        assertNull(repository.findById(10001));
    }

    @Test
    @DirtiesContext//reset data after testing
    void save_basic() {
        //get a course
        Course course = repository.findById(10001);
        assertEquals("JPA in 50 steps", course.getName());

        //update details
        course.setName("JPA in 50 steps - Updated");
        repository.save(course);

        //check the value
        Course course1 = repository.findById(10001);
        assertEquals("JPA in 50 steps - Updated", course1.getName());
    }

    void playWithEntityManager() {
        repository.playWithEntityManager();
    }
}
