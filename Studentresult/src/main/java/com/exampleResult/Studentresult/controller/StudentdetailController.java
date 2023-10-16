package com.exampleResult.Studentresult.controller;

import com.exampleResult.Studentresult.Entity.*;
import com.exampleResult.Studentresult.exceptions.InvalidDobException;
import com.exampleResult.Studentresult.exceptions.StudentNotFoundException;
import com.exampleResult.Studentresult.exceptions.StudentpresentException;
import com.exampleResult.Studentresult.exceptions.mycustomexception;
import com.exampleResult.Studentresult.process.Datafetch;
import com.exampleResult.Studentresult.service.Studentdetail;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping("/students")
public class StudentdetailController {

    private Datafetch studentdetail;
    @Autowired
    public StudentdetailController(Datafetch studentdetail) {
        this.studentdetail = studentdetail;
    }
     @GetMapping("/all")
    public List<Student> findall() {
        List<Student> students=studentdetail.findall();
        return students;
    }


    @PostMapping("/getresult")
    public String getresult(@RequestBody Map<String, Object> requestBody, Model model) throws mycustomexception {

        studentdetail.checkmissingparameter(requestBody);


        int studentID = (int) requestBody.get("studentID");
        String studentdob = (String) requestBody.get("studentdob");

        List<Student> st = studentdetail.getquery(studentID,studentdob);
        if (st.isEmpty()) {
            throw new InvalidDobException("Student not found with ID: " + studentID + " Date of Birth "+ studentdob);
        }

        Resultdetail ls = studentdetail.Resultgrade(studentID);
        model.addAttribute("result", ls);
        return "result";
    }
    @ExceptionHandler(StudentNotFoundException.class)
    public String handleStudentNotFoundException(StudentNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());

        return "error";
    }
    @ExceptionHandler(StudentpresentException.class)
    public String handlestudentpresent(StudentpresentException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());

        return "error";
    }

    @ExceptionHandler(InvalidDobException.class)
    public String handleInvalidDobException(InvalidDobException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
    }
    @PostMapping("/addstudent")
    public ResponseEntity<String> addstudententity(@RequestBody StudentMarks studentmarks){
        Student student=studentmarks.getStudent();
        if(studentdetail.findstudentid(student.getStudentid())!=-1){
            throw new StudentpresentException("Student is already Present "+ student.getStudentid());
        }
        studentdetail.addStudent(student);
        int id=student.getStudentid();
        for(Marks marks: studentmarks.getMarks()){
            marks.setStudentid(id);
            studentdetail.addmarks(marks);
        }
        return ResponseEntity.ok("Student and Marks added successfully");
    }
    @PostMapping("/studentsadd")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        // code to save student data to the database
        System.out.println(student.toString());
        studentdetail.addStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }
    @PostMapping("/marksadd")
    public ResponseEntity<String> addmarks(@RequestBody Marks marks) {
        // code to save student data to the database
        studentdetail.addmarks(marks);
        return ResponseEntity.ok("Marks are added successfully");
    }
    /*
    @PostMapping("/employeesadd")
    public Student addemployee(@RequestBody Student theemp ){
        theemp.setId(0);
        Employee emp=employeeService.save(theemp);
        return emp;
    }
     */
}
