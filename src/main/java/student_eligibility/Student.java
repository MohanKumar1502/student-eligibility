package student_eligibility;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String studentId;
    private String name;
    private double cgpa;
    private boolean backlog;

    // Constructors, getters, setters
    public Student() {}

    public Student(String studentId, String name, double cgpa, boolean backlog) {
        this.studentId = studentId;
        this.name = name;
        this.cgpa = cgpa;
        this.backlog = backlog;
    }

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    public boolean isBacklog() { return backlog; }
    public void setBacklog(boolean backlog) { this.backlog = backlog; }
}