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
        return "Check Page Working ✅";
    }

    @GetMapping("/students")
    public String students() {
        return "Students Page Working ✅";
    }

    @GetMapping("/search")
    public String search() {
        return "Search Page Working ✅";
    }
}