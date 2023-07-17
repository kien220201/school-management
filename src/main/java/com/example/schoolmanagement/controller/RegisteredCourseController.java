package com.example.schoolmanagement.controller;
import org.springframework.ui.Model;

import com.example.schoolmanagement.model.RegisteredCourse;
import com.example.schoolmanagement.repository.RegisteredCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/registeredCourses")
public class RegisteredCourseController {
    private final RegisteredCourseRepository registeredCourseRepository;

    @Autowired
    public RegisteredCourseController(RegisteredCourseRepository registeredCourseRepository) {
        this.registeredCourseRepository = registeredCourseRepository;
    }

    @PostMapping
    public String createRegisteredCourse(@RequestBody RegisteredCourse registeredCourse) {
        registeredCourseRepository.save(registeredCourse);
        Long studentId = registeredCourse.getStudent().getId();
        return "redirect:/students/" + studentId + "/registeredCourses";
    }

    @DeleteMapping("/{id}")
    public void deleteRegisteredCourse(@PathVariable Long id) {
        registeredCourseRepository.deleteById(id);
    }

    @GetMapping("/{studentId}")
    public String getRegisteredCourses(@PathVariable Long studentId, Model model) {
        List<RegisteredCourse> registeredCourses = registeredCourseRepository.findByStudentId(studentId);
        model.addAttribute("registeredCourses", registeredCourses);
        return "registeredCourses";
    }

    // Các phương thức truy vấn khác nếu cần
}