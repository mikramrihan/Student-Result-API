package com.exampleResult.Studentresult.service;

import com.exampleResult.Studentresult.Entity.Student;

import java.util.List;

public interface Studentdetail {
    List<Student> findall();
    Student find(int id);
    int findid(int id);
    Student save(Student student);
    int findlatestid();
////    void deletebyId(int id);
    public List<Student> getquery(int studentID, String studentdob);

}
