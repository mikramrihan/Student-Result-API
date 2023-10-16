package com.exampleResult.Studentresult.process;

import com.exampleResult.Studentresult.Entity.Marks;
import com.exampleResult.Studentresult.Entity.Resultdetail;
import com.exampleResult.Studentresult.Entity.Student;
import com.exampleResult.Studentresult.Entity.Subjectreport;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


public interface Datafetch {
    List<Student> findall();
    Student findstudent(int id);
    int findstudentid(int id);
    Marks findmarks(int id);
    public List<Subjectreport> SubjectGrade(int studentid);
    Resultdetail Resultgrade(int studentid);
    public void addStudent(Student student);
    public void addmarks(Marks marks);
    int findlatestid();
    public List<Student> getquery(int studentID, String studentdob);
    public void checkmissingparameter(Map<String,Object> requestBody);
}
