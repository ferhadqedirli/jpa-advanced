package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import com.example.demohibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class JPQLTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic() {
        Query query = em.createNamedQuery("query_get_all_courses");
        List resultList = query.getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_where() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_100_step_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c where c.name like '%100 Steps' -> {}", resultList);
    }

    @Test
    void jpql_courses_without_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses without students -> {}", resultList);
    }

    @Test
    void jpql_courses_with_more_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.students.size >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses with more students -> {}", resultList);
    }

    @Test
    void jpql_courses_ordered_by_students() {
        TypedQuery<Course> query = em.createQuery("select c from Course c order by c.students.size desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses with more students -> {}", resultList);
    }

    @Test
    void jpql_students_with_passports_in_a_certain_pattern() {
        TypedQuery<Student> query = em.createQuery("select s from Student s where s.passport.number like '%257%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results -> {}", resultList);
    }

    @Test
    void join() {
        Query query = em.createQuery("select c, s from Course c join c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} Student {}", result[0], result[1]);
        }
    }

    @Test
    void left_join() {
        Query query = em.createQuery("select c, s from Course c left join c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} Student {}", result[0], result[1]);
        }
    }

    @Test
    void cross_join() {
        Query query = em.createQuery("select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Results size -> {}", resultList.size());
        for (Object[] result : resultList) {
            logger.info("Course {} Student {}", result[0], result[1]);
        }
    }
}
