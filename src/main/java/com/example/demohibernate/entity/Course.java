package com.example.demohibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_all_courses_join_fetch", query = "select c from Course c join fetch c.students s"),
        @NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '%100 Steps'")
})
@Cacheable
@SQLDelete(sql = "update course set is_deleted = true where id = ?")//soft delete
@Where(clause = "is_deleted = false")//select zamani is_deleted = false olan
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "course")
    private final List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private final List<Student> students = new ArrayList<>();

    private boolean isDeleted;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @PreRemove
    private void preRemove() {
        this.isDeleted = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "\nCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
