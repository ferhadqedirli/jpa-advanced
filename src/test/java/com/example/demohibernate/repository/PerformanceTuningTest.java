package com.example.demohibernate.repository;

import com.example.demohibernate.DemoHibernateApplication;
import com.example.demohibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoHibernateApplication.class)
class PerformanceTuningTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void creatingNPlusOneProblem() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");
        List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();
        for (Course course : courses) {
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

    @Test
    @Transactional
    void solvingNPlusOneProblem_JoinFetch() {
        List<Course> courses = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class)
                .getResultList();
        for (Course course : courses) {
            logger.info("Course -> {} Students -> {}", course, course.getStudents());
        }
    }

}
