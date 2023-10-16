package com.exampleResult.Studentresult.Entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
@IdClass(value = Marks.class)
@Entity
@Table(name="marks")
public class Marks {
    @Id
    @Column(name="studentid")
    @NotNull(message = "studentid is not present ")
    private int studentid;
    @Id
    @Column(name="subjectcode")
    @NotNull(message = "subject code is not present ")
    private String subjectcode;
    @Column(name="subjectname")
    @NotNull(message = "subject name is not present ")
    private String subjectname;
    @Column(name="maxmarks")
    @NotNull(message = "maxmarks is not present ")
    private int maxmarks;
    @Column(name="marksobt")
    @NotNull(message = "obtained marks is not present ")
    private int marksobt;
    public Marks() {
    }

    public Marks(int studentid, String subjectcode, String subjectname, int maxmarks, int marksobt) {
        this.studentid = studentid;
        this.subjectcode = subjectcode;
        this.subjectname = subjectname;
        this.maxmarks = maxmarks;
        this.marksobt = marksobt;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getMaxmarks() {
        return maxmarks;
    }

    public void setMaxmarks(int maxmarks) {
        this.maxmarks = maxmarks;
    }

    public int getMarksobt() {
        return marksobt;
    }

    public void setMarksobt(int marksobt) {
        this.marksobt = marksobt;
    }
}
