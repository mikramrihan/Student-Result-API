package com.exampleResult.Studentresult.Entity;

import java.util.List;

public class StudentMarks {
    private Student student;
    private List<Marks> marks;

    public StudentMarks(Student student, List<Marks> marks) {
        this.student = student;
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Marks> getMarks() {
        return marks;
    }

    public void setMarks(List<Marks> marks) {
        this.marks = marks;
    }
}
