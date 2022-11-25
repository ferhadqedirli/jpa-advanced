package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@SpringBootTest(classes = DemoHibernateApplication.class)
class StudentRepositoryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void retrieve_student_and_passport_details() {
        Student student = em.find(Student.class, 2);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

}
