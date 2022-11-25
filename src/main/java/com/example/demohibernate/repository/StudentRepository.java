package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Passport;
import com.example.demohibernate.entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    public void deleteById(Integer id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public Student save(Student Student) {
        if (Student.getId() == null) {
            entityManager.persist(Student);
        } else {
            entityManager.merge(Student);
        }
        return Student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("AZ2554789");
        entityManager.persist(passport);

        Student student = new Student("Tony");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void someOperationToUnderstandPersistenceContext() {
        //Database operation 1 - Retrieve Student
        Student student = entityManager.find(Student.class, 2);
        //Persistence Context(student)

        //Database operation 2 - Retrieve Passport
        Passport passport = student.getPassport();
        //Persistence Context(student, passport)

        //Database operation 3 - Update Passport
        passport.setNumber("AE7412589");
        //Persistence Context(student, passport++)

        //Database operation 4 - Update Student
        student.setName("Tony Shelby");
        //Persistence Context(student++, passport++)
    }
}
