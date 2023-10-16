package com.exampleResult.Studentresult.Entity;

import jakarta.persistence.Entity;


public class Subjectreport {
    private String subjectcode;
    private String subjectname;
    private int maxmarks;
    private int obtmarks;
    private String Grade;
    private String passorfail;

    public Subjectreport(String subjectcode, String subjectname, int maxmarks, int obtmarks) {
        this.subjectcode = subjectcode;
        this.subjectname = subjectname;
        this.maxmarks = maxmarks;
        this.obtmarks = obtmarks;
        setGrade();
        setPassorfail();

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

    public int getObtmarks() {
        return obtmarks;
    }

    public void setObtmarks(int obtmarks) {
        this.obtmarks = obtmarks;
        setGrade();
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade() {
        int percent= this.obtmarks;

        if(percent>=90){
           this.Grade="A+";
        }
        else if(percent>=80){
            this.Grade="A-";
        }
        else if(percent>=70){
            this.Grade="B+";
        }
        else if(percent>=60){
            this.Grade="B-";
        }
        else if(percent>=50){
            this.Grade="C+";
        }
        else if(percent>=40){
            this.Grade="C-";
        }
        else{
            this.Grade="F";
        }
        setPassorfail();
    }

    public String getPassorfail() {
        return passorfail;
    }

    public void setPassorfail() {
        this.passorfail = (this.getGrade()=="F")?"FAIL":"PASS";
    }

    @Override
    public String toString() {
        return   subjectcode + " | " +
                 subjectname + " | " +
                 maxmarks + " | " +
                 obtmarks + " | " +
                Grade + " | " +
                '\n';
    }
}
