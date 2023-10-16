package com.exampleResult.Studentresult.service;

import ch.qos.logback.core.model.Model;
import com.exampleResult.Studentresult.Data.Studentdata;
import com.exampleResult.Studentresult.Entity.Student;
import com.exampleResult.Studentresult.exceptions.StudentNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class studentdetailsimp implements Studentdetail{
    private Studentdata studentdetail;
    @Autowired
    public studentdetailsimp(Studentdata studentdetail) {
        this.studentdetail = studentdetail;
    }

    @Override
    public List<Student> findall(){
        return studentdetail.findAll();
    }

    @Override
    public Student find(int id) {
        Optional<Student> opt= studentdetail.findById(id);
        if(opt.isPresent()){
            return opt.get();
        }
        else{
            throw new StudentNotFoundException("STUDENT NOT FOUND "+ id);
        }
    }

    @Override
    public int findid(int id) {
        Optional<Student> opt= studentdetail.findById(id);
        System.out.println(opt.isPresent()?"YES":"NO");
        if(opt.isPresent()){
            return opt.get().getStudentid();
        }
        else{
            return -1;
        }
    }

    @Override
    @Transactional
    public Student save(Student theemployee) {
        return studentdetail.save(theemployee);
    }
    public int findlatestid(){
        Long id= studentdetail.getLastInsertedId();
        return ((int)id.intValue());
    }

    @Override
    public List<Student> getquery(int studentID, String studentdob) {
        return studentdetail.findByStudentidAndStudentdob(studentID,studentdob);
    }
//    @Override
//    @Transactional
//    public void deletebyId(int id) {
//        employeedao.deletebyId(id);
//    }


}
