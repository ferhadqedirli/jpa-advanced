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
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest(classes = DemoHibernateApplication.class)
class NativeQueriesTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void native_queries_basic() {
        Query query = em.createNativeQuery("select * from course", Course.class);
        List resultList = query.getResultList();
        logger.info("select * from course -> {}", resultList);
    }

    @Test
    void native_queries_with_parameter() {
        Query query = em.createNativeQuery("select * from course where id = ?", Course.class);
        query.setParameter(1, 10001);
        List resultList = query.getResultList();
        logger.info("select * from course where id = ? -> {}", resultList);
    }

    @Test
    void native_queries_with_named_parameter() {
        Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10003);
        List resultList = query.getResultList();
        logger.info("select * from course where id = :id -> {}", resultList);
    }

    @Test
    @Transactional
    void native_queries_to_update() {
        Query query = em.createNativeQuery("update course set last_updated_date = current_timestamp", Course.class);
        int numberOfRowsUpdated = query.executeUpdate();
        logger.info("numberOfRowsUpdated -> {}", numberOfRowsUpdated);
    }

}
