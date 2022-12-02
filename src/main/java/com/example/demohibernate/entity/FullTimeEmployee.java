package com.example.demohibernate.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
    private Double salary;

    public FullTimeEmployee(Double salary) {
        this.salary = salary;
    }

    protected FullTimeEmployee() {
    }

    public FullTimeEmployee(String name, Double salary) {
        super(name);
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nPartTimeEmployee{" +
                "salary=" + salary +
                '}';
    }
}
