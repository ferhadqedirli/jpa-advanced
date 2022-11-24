package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {

    private final EntityManager entityManager;

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Integer id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
}
