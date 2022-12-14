package com.example.demohibernate.repository;

import com.example.demohibernate.entity.Course;
import com.example.demohibernate.entity.Review;
import com.example.demohibernate.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private final EntityManager entityManager;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(Integer id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Integer id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("Web Services in 100 Steps");
        entityManager.persist(course);

        Course course1 = findById(10001);
        course1.setName("JPA in 50 Steps - Updated");
    }

    public void addHardcodedReviewsForCourse() {
        Course course = findById(10003);
        logger.info("Reviews -> {}", course.getReviews());
        Review review1 = new Review(ReviewRating.FIVE, "Great Hands-on Stuff.");
        Review review2 = new Review(ReviewRating.FIVE, "Hatsoff.");

        course.addReview(review1);
        review1.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void addReviewsForCourse(Integer courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("Reviews -> {}", course.getReviews());

        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);

            entityManager.persist(review);
        }
    }
}
