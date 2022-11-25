package com.example.demohibernate.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    protected Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public Passport(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\nPassport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
