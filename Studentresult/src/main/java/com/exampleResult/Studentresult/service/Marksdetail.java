package com.exampleResult.Studentresult.service;

import com.exampleResult.Studentresult.Entity.Marks;
import com.exampleResult.Studentresult.Entity.Student;

import java.util.List;

public interface Marksdetail {
    List<Marks> findall();
    Marks find(int id);
    List<Marks> findbyid(int id);
    Marks save(Marks marks);

    List<Marks> findbystudentid(int studentid);
}
