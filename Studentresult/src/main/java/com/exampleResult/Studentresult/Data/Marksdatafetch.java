package com.exampleResult.Studentresult.Data;

import com.exampleResult.Studentresult.Entity.Marks;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class Marksdatafetch {

    private Marksdata studentRepository;

    public List<Marks> findbystudentid(int studentid) {
        return studentRepository.findbystudentid(studentid);
    }
//    public List<Marks> findbycomponentskey(int studentid, String subjectcode){
//        return studentRepository.findbycomponentskey(studentid,subjectcode);
//    }


}
