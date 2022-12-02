package com.example.demohibernate.entity;

import javax.persistence.*;

@Entity
//@NamedQueries(value = {
//        @NamedQuery(name = "get-all_employee", query = "select e from Employee e")
//})
public abstract class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    protected Employee() {
    }

    public Employee(String name) {
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
        return "\nEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
