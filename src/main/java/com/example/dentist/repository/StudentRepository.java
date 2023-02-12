package com.example.dentist.repository;

import com.example.dentist.model.Student;

import com.example.dentist.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying
    @Query("delete from Student s where s.email=:email")
    void deleteByEmail(@Param("email")String email);

//    @Query("delete from student_breakTime s where s.email=:email")
//    void deleteTime(@Param("time") Time time);
}

//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//
//
//public interface StudentRepository extends MongoRepository<Student, String> {
//
//
//}