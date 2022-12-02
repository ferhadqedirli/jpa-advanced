package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private final EntityManager entityManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insertEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    public List<Employee> retrieveAllEmployee() {
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }
}
