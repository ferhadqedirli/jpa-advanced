package com.example.demohibernate.entity;

import javax.persistence.Entity;

@Entity
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
