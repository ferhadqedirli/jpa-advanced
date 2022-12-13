package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Integer> {
    List<Course> findAllByName(String name);
    List<Course> findByNameAndId(String name, Integer id);
    List<Course> countByName(String name);
    List<Course> findByNameOrderByIdDesc(String name);
    List<Course> deleteByName(String name);
    @Query("select c from Course c where c.name like '%100 steps'")
    List<Course> coursesWith100Steps();

    @Query(value = "select * from course c where c.name like '%100 steps'", nativeQuery = true)
    List<Course> coursesWith100StepsNative();

    @Query(name = "query_get_all_courses")
    List<Course> coursesWith100StepsNamed();
}
