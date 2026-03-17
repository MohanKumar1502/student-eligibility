package student_eligibility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.annotation.PostConstruct;

@Controller
public class HomeController {

    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void initData() {
        studentRepository.save(new Student("S001", "John Doe", 8.5, false));
        studentRepository.save(new Student("S002", "Jane Smith", 6.5, true));
        studentRepository.save(new Student("S003", "Alice Johnson", 9.0, false));
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        return "index";
    }

    @GetMapping("/check")
    public String checkPage(Model model) {
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        model.addAttribute("student", new Student());
        return "check";
    }

    @PostMapping("/check")
    public String checkEligibility(@ModelAttribute Student student, Model model) {
        boolean placementEligible = student.getCgpa() >= 7.0 && !student.isBacklog();
        studentRepository.save(student);
        model.addAttribute("student", student);
        model.addAttribute("placementEligible", placementEligible);
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        return "result";
    }

    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        return "search";
    }

    @PostMapping("/search")
    public String searchStudent(@RequestParam String studentId, Model model) {
        studentId = studentId.trim();
        Student student = studentRepository.findById(studentId).orElse(null);
        model.addAttribute("searchedStudent", student);
        model.addAttribute("searchedId", studentId);
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        return "search";
    }

    @GetMapping("/students")
    public String studentsPage(Model model) {
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable String id, Model model) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return "redirect:/";
        }
        model.addAttribute("student", student);
        model.addAttribute("appName", "Student Placement Eligibility Checker");
        return "edit";
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute Student student, Model model) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @PostMapping("/clear")
    public String clearAllStudents() {
        studentRepository.deleteAll();
        return "redirect:/students";
    }
}
