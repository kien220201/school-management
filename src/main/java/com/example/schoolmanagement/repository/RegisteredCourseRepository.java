package com.example.schoolmanagement.repository;

import com.example.schoolmanagement.model.Course;
import com.example.schoolmanagement.model.RegisteredCourse;
import com.example.schoolmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisteredCourseRepository extends JpaRepository<RegisteredCourse, Long> {
    RegisteredCourse findFirstByStudentAndCourse(Student student, Course course);
    List<RegisteredCourse> findByStudentIdEquals(Long studentId);

    List<RegisteredCourse> findByStudentId(Long studentId);
}
