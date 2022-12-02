package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Employee;
import com.example.demohibernate.entity.FullTimeEmployee;
import com.example.demohibernate.entity.PartTimeEmployee;
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

    public List<PartTimeEmployee> retrieveAllPartTimeEmployee() {
        TypedQuery<PartTimeEmployee> query = entityManager.createNamedQuery("get_all_part_time_employee", PartTimeEmployee.class);
        return query.getResultList();
    }

    public List<FullTimeEmployee> retrieveAllPFullTimeEmployee() {
        TypedQuery<FullTimeEmployee> query = entityManager.createNamedQuery("get_all_full_time_employee", FullTimeEmployee.class);
        return query.getResultList();
    }
}
