package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

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
        Query query = em.createQuery("select c from Course c");
        List resultList = query.getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_typed() {
        TypedQuery<Course> query = em.createQuery("select c from Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_where() {
        TypedQuery<Course> query = em.createQuery("select c from Course c where c.name like '%100 Steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c where c.name like '%100 Steps' -> {}", resultList);
    }

}
