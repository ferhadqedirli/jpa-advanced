package com.example.demohibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "\nCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
