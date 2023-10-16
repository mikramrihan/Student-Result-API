package com.exampleResult.Studentresult.Data;

import com.exampleResult.Studentresult.Entity.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Marksdata extends JpaRepository<Marks, Integer> {
//    @Query("SELECT m FROM marks WHERE m.studentid = ?1")
    @Query("SELECT s FROM Marks s WHERE s.studentid = :id")
    List<Marks> findbystudentid(@Param("id") int id);
//    @Query("SELECT s FROM Marks s WHERE s.studentid = :id AND s.subjectcode= :subcode")
//    List<Marks> findbycomponentskey(@Param("id") int id, @Param("subcode") String code);

}
