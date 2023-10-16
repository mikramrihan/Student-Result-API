package com.exampleResult.Studentresult.Entity;

import java.util.List;

public class Resultdetail {
    private studentcopy studentcopy;
    private List<Subjectreport> subjectreport;
    private String Grandtotal;
    private String Overallgrade;
    private String passorfail;

    private String Attandances;

    public Resultdetail(studentcopy studentcopy, List<Subjectreport> subjectreport,  int attandances) {

        this.studentcopy = studentcopy;
        this.subjectreport = subjectreport;
        setGrandtotal();
        setOverallgrade();
        setAttandances(attandances);
        setPassorfail();


    }

    public studentcopy getStudentcopy() {
        return studentcopy;
    }

    public void setStudentcopy(studentcopy studentcopy) {
        this.studentcopy = studentcopy;
    }

    public List<Subjectreport> getSubjectreport() {
        return subjectreport;
    }

    public void setSubjectreport(List<Subjectreport> subjectreport) {
        this.subjectreport = subjectreport;
    }

    public String getGrandtotal() {
        return Grandtotal;
    }

    public void setGrandtotal() {
        int sum=0;

        for(Subjectreport st1 : this.subjectreport) sum += st1.getObtmarks();
        this.Grandtotal=sum+" / "+"500";
        setOverallgrade();
    }

    public String getOverallgrade() {
        return Overallgrade;
    }

    public void setOverallgrade() {
        int sum=0;

        for(Subjectreport st1 : this.subjectreport) sum += st1.getObtmarks();
        float ft= (float) ((float)sum/5.0);
        this.Overallgrade=(ft>=85.0)?"A":(ft>=70)?"B":(ft>=60)?"C":(ft>=40)?"D":"F";
    }

    public String getAttandances() {
        return Attandances;
    }

    public void setAttandances(int attandances) {
        this.Attandances = attandances+" / "+"365";
    }

    public String getPassorfail() {
        return passorfail;
    }

    public void setPassorfail() {
        boolean f=true;
        for(Subjectreport st: this.subjectreport){
            if(st.getPassorfail()=="FAIL"){
                f=false;
                break;
            }
        }
        this.passorfail=(f==true)?"PASS":"FAIL";
    }

    @Override
    public String toString() {
        return "------------------------------RESULT-------------------------------- /\n\n" +
                "STUDENT DATA =============================>  \n" + studentcopy +
                "\n\n\nSUBJECT REPORT ===========================>\n\n" + subjectreport +
                "\n\n\nGrandtotal == " + Grandtotal +
                "\nOverallgrade == " + Overallgrade +
                "\n\nAttandances == " + Attandances ;
    }
}
