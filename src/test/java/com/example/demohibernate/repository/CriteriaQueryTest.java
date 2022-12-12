package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
}
