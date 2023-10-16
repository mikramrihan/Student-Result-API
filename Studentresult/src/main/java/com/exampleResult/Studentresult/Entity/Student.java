package com.exampleResult.Studentresult.Entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Student")
public class Student {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentid")
    @NotNull(message = "student ID is not present ")
    private  int studentid;
    @Column(name="studentname")
    @NotNull(message = "student name is not present ")
    private  String studentname;
    @Column(name="studentdob")
    @NotNull(message = "student Date of Birth is not present ")
    private String studentdob;
    @Column(name="schoolname")
    @NotNull(message = "School name is not present ")
    private  String schoolname;
    @Column(name="schooladdress")
    @NotNull(message = "school address is not present ")
    private String schooladdress;
    @Column(name="studentattendance")
    @NotNull(message = "student is attandances not present ")
    private int studentattendance;
    public Student() {
    }

    public Student(int studentid, String studentname, String studentdob, String schoolname, String schooladdress, int studentattendance) {
        this.studentid = studentid;
        this.studentname = studentname;
        this.studentdob = studentdob;
        this.schoolname = schoolname;
        this.schooladdress = schooladdress;
        this.studentattendance = studentattendance;
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

    public int getStudentattendance() {
        return studentattendance;
    }

    public void setStudentattendance(int studentattendance) {
        this.studentattendance = studentattendance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", studentname='" + studentname + '\'' +
                ", studentdob='" + studentdob + '\'' +
                ", schoolname='" + schoolname + '\'' +
                ", schooladdress='" + schooladdress + '\'' +
                ", studentattendance=" + studentattendance +
                '}';
    }
}
