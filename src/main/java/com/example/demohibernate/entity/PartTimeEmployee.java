package com.example.demohibernate.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "get_all_part_time_employee", query = "select pe from PartTimeEmployee pe")
public class PartTimeEmployee extends Employee{
    private Double hourlyWage;

    public PartTimeEmployee(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    protected PartTimeEmployee() {
    }

    public PartTimeEmployee(String name, Double hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Override
    public String toString() {
        return "\nPartTimeEmployee{" +
                "hourlyWage=" + hourlyWage +
                '}';
    }
}
