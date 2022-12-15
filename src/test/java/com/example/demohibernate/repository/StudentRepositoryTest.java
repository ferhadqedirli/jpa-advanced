package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Address;
import com.example.demohibernate.entity.Course;
import com.example.demohibernate.entity.Passport;
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
    void someTest() {
        repository.someOperationToUnderstandPersistenceContext();
    }

    @Test
    @Transactional
    void retrieve_student_and_passport_details() {
        Student student = em.find(Student.class, 20002);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void retrieve_passport_and_associated_student() {
        Passport passport = em.find(Passport.class, 40001);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    void retrieve_student_and_courses() {
        Student student = em.find(Student.class, 20001);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    void retrieve_course_and_students() {
        Course course = em.find(Course.class, 10001);
        logger.info("course -> {}", course);
        logger.info("students -> {}", course.getStudents());
    }

    @Test
    @Transactional
    void set_address_details() {
        Student student = em.find(Student.class, 20001);
        student.setAddress(new Address("Yasamal", "2-ci Alatava", "Baku"));
        em.flush();
        logger.info("student -> {}", student);
        logger.info("address -> {}", student.getAddress());
    }

}
