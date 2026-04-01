package com.placement.student_eligibility;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Student Eligibility App is Running 🚀";
    }

    @GetMapping("/check")
    public String check() {
        return "Check API Working ✅";
    }

    @GetMapping("/students")
    public String students() {
        return "Students API Working ✅";
    }
}