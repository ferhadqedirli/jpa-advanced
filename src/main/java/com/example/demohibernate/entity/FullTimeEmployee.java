package com.example.demohibernate.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "get_all_full_time_employee", query = "select fe from FullTimeEmployee fe")
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
