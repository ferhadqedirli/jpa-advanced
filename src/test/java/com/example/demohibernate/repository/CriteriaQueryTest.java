package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest(classes = DemoHibernateApplication.class)
class CriteriaQueryTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        TypedQuery<Course> query = em.createQuery(criteriaQuery.select(root));
        List<Course> resultList = query.getResultList();
        logger.info("Result -> {}", resultList);
    }

    @Test
    void all_courses_having_100_steps() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        Predicate like = cb.like(root.get("name"), "%100 steps");
        criteriaQuery.where(like);
        TypedQuery<Course> query = em.createQuery(criteriaQuery.select(root));
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c where c.name like '%100 Steps' -> {}", resultList);
    }

    @Test
    void all_courses_without_students() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        Predicate isEmpty = cb.isEmpty(root.get("students"));
        criteriaQuery.where(isEmpty);
        TypedQuery<Course> query = em.createQuery(criteriaQuery.select(root));
        List<Course> resultList = query.getResultList();
        logger.info("select c from Course c where students is empty -> {}", resultList);
    }

    @Test
    void join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        root.join("students");

        TypedQuery<Course> query = em.createQuery(criteriaQuery.select(root));
        List<Course> resultList = query.getResultList();
        logger.info("Join result -> {}", resultList);
    }

    @Test
    void left_join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = cb.createQuery(Course.class);

        Root<Course> root = criteriaQuery.from(Course.class);

        root.join("students", JoinType.LEFT);

        TypedQuery<Course> query = em.createQuery(criteriaQuery.select(root));
        List<Course> resultList = query.getResultList();
        logger.info("Join result -> {}", resultList);
    }
}
