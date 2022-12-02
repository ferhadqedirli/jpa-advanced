package com.example.demohibernate;

import com.example.demohibernate.entity.Course;
import com.example.demohibernate.entity.Passport;
import com.example.demohibernate.entity.Review;
import com.example.demohibernate.entity.Student;
import com.example.demohibernate.repository.CourseRepository;
import com.example.demohibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoHibernateApplication implements CommandLineRunner {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DemoHibernateApplication(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        studentRepository.saveStudentWithPassport();
//        courseRepository.addHardcodedReviewsForCourse();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "Great Hands-on Stuff."));
//        reviews.add(new Review("5", "Hatsoff."));
//
//        courseRepository.addReviewsForCourse(10003, reviews);
//        studentRepository.insertHardcodedStudentAndCourse();
        studentRepository.insertStudentAndCourse(new Student("Jack"),
                new Course("Microservices in 100 Steps"),
                new Passport("AJ8554547"));
    }
}
