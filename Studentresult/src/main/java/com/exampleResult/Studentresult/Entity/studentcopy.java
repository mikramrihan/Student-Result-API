package com.exampleResult.Studentresult.Entity;

import jakarta.persistence.Column;

public class studentcopy {
    private  int studentid;

    private  String studentname;

    private String studentdob;

    private  String schoolname;

    private String schooladdress;

    public studentcopy(int studentid, String studentname, String studentdob, String schoolname, String schooladdress) {
        this.studentid = studentid;
        this.studentname = studentname.toUpperCase();
        this.studentdob = studentdob.toUpperCase();
        this.schoolname = schoolname.toUpperCase();
        this.schooladdress = schooladdress.toUpperCase();
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentdob() {
        return studentdob;
    }

    public void setStudentdob(String studentdob) {
        this.studentdob = studentdob;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSchooladdress() {
        return schooladdress;
    }

    public void setSchooladdress(String schooladdress) {
        this.schooladdress = schooladdress;
    }

    @Override
    public String toString() {
        return "STUDENT ID = " + studentid + '\n'+
                "STUDENT NAME = " + studentname +
                " | STUDENT DATEOFBIRTH = " + studentdob + '\n' +
                " | SCHOOL NAME = " + schoolname +
                " | SCHOOLADDRESS = " + schooladdress
                ;
    }


}
