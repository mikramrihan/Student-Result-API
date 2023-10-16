package com.exampleResult.Studentresult.Data;

import com.exampleResult.Studentresult.Entity.Marks;
import com.exampleResult.Studentresult.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface Studentdata extends JpaRepository<Student, Integer> {
        @Query(value = "SELECT max(student.studentid) FROM Student student")
        Long getLastInsertedId();
//    @Query("SELECT s from student s where studentid=:id AND studentdob=:dob")
//    List<Student>  getquery(@Param("id") int id, @Param("dob") String dob);
        List<Student> findByStudentidAndStudentdob(int studentid, String studentdob);

}
