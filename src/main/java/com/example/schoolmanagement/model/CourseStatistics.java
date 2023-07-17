package com.example.schoolmanagement.model;

import com.example.schoolmanagement.repository.RegisteredCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseStatistics {

    private final RegisteredCourseRepository registeredCourseRepository;

    @Autowired
    public CourseStatistics(RegisteredCourseRepository registeredCourseRepository) {
        this.registeredCourseRepository = registeredCourseRepository;
    }

    public Map<Course, Integer> getEnrollmentStatistics() {
        List<RegisteredCourse> registeredCourses = registeredCourseRepository.findAll();

        Map<Course, Integer> enrollmentStatistics = new HashMap<>();

        for (RegisteredCourse registeredCourse : registeredCourses) {
            Course course = registeredCourse.getCourse();
            enrollmentStatistics.put(course, enrollmentStatistics.getOrDefault(course, 0) + 1);
        }

        return enrollmentStatistics;
    }
}
