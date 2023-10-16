package com.exampleResult.Studentresult.service;

import com.exampleResult.Studentresult.Data.Marksdata;
import com.exampleResult.Studentresult.Entity.Marks;
import com.exampleResult.Studentresult.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class marksdetailsimp implements Marksdetail {
    private Marksdata studentmarks;
    @Autowired
    public marksdetailsimp(Marksdata studentmarks) {
        this.studentmarks = studentmarks;

    }

    @Override
    public List<Marks> findall(){
        return studentmarks.findAll();
    }

    @Override
    public Marks find(int id) {
        Optional<Marks> opt= studentmarks.findById(id);
        if(opt.isEmpty()){
            throw new RuntimeException("Marks id is not found "+ id);
        }
        else{
            return opt.get();
        }
    }

    @Override
    public List<Marks> findbyid(int id) {
        return studentmarks.findbystudentid(id);
    }

    @Override
    @Transactional
    public Marks save(Marks marks) {
        return studentmarks.save(marks);
    }

    @Override
    public List<Marks> findbystudentid(int studentid) {
        return studentmarks.findbystudentid(studentid);
    }

}
