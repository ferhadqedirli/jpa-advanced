package com.example.demohibernate;

import com.example.demohibernate.entity.Course;
import com.example.demohibernate.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHibernateApplication implements CommandLineRunner {

    private final CourseRepository repository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public DemoHibernateApplication(CourseRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoHibernateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course course = repository.findById(10001);
//        logger.info("Course 10001 -> {} ", course);
//        repository.save(new Course(10001, "Jpa in 50 steps"));
//        repository.playWithEntityManager();
    }
}
