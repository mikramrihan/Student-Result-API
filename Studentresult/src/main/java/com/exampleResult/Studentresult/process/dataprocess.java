package com.exampleResult.Studentresult.process;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.exampleResult.Studentresult.Data.Marksdata;
import com.exampleResult.Studentresult.Data.Studentdata;
import com.exampleResult.Studentresult.Entity.*;
import com.exampleResult.Studentresult.exceptions.mycustomexception;
import com.exampleResult.Studentresult.service.Marksdetail;
import com.exampleResult.Studentresult.service.Studentdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class dataprocess implements Datafetch  {
    @Autowired
    private Studentdetail studentdetail;
    @Autowired
    private Marksdetail marksdetail;

//    public dataprocess(Studentdetail studentdetail, Marksdetail marksdetail) {
//        this.studentdetail = studentdetail;
//        this.marksdetail = marksdetail;
//    }


    @Override
    public List<Student> findall() {
        return studentdetail.findall();
    }

    @Override
    public Student findstudent(int id) {
        return studentdetail.find(id);
    }

    @Override
    public int findstudentid(int id) {
        return studentdetail.findid(id);
    }

    @Override
    public Marks findmarks(int id){
        return marksdetail.find(id);
    }


    @Override
    public List<Subjectreport> SubjectGrade(int studentid){
        List<Marks> marksdata=marksdetail.findbyid(studentid);
        List<Subjectreport> ls = new ArrayList<>();
        for(Marks mk : marksdata){
            Subjectreport st=new Subjectreport(mk.getSubjectcode(),mk.getSubjectname(),mk.getMaxmarks(),mk.getMarksobt());

            ls.add(st);
        }
        System.out.println(ls.toString());
        return ls;

    }

    @Override
    public Resultdetail Resultgrade(int studentid) {
        List<Marks> marksdata=marksdetail.findbystudentid(studentid);
        List<Subjectreport> ls = new ArrayList<>();
        for(Marks mk : marksdata){
            Subjectreport st=new Subjectreport(mk.getSubjectcode(),mk.getSubjectname(),mk.getMaxmarks(),mk.getMarksobt());

            ls.add(st);
        }
        Student st=studentdetail.find(studentid);
        studentcopy ss= new studentcopy(st.getStudentid(),st.getStudentname(),st.getStudentdob(),st.getSchoolname(),st.getSchooladdress());
        Resultdetail rs=new Resultdetail(ss,ls,st.getStudentattendance());
        return rs;
    }


    public void addStudent(Student student) {
        studentdetail.save(student);
    }
    public void addmarks(Marks marks) {
        marksdetail.save(marks);
    }
    public int findlatestid(){
        return studentdetail.findlatestid();
    }

    @Override
    public List<Student> getquery(int studentID, String studentdob) {
        return studentdetail.getquery(studentID,studentdob);
    }
    public void checkmissingparameter(Map<String,Object> requestBody){
        if (!requestBody.containsKey("studentID")) {
            try {
                throw new mycustomexception("Missing parameter: studentID ");
            } catch (mycustomexception e) {
                throw new RuntimeException(e);
            }
        }
        if (!requestBody.containsKey("studentdob")) {
            try {
                throw new mycustomexception("Missing parameter: studentdob " );
            } catch (mycustomexception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
