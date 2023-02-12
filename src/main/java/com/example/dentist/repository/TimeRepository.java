package com.example.dentist.repository;

import com.example.dentist.model.Student;
import com.example.dentist.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

@Repository
public interface TimeRepository extends JpaRepository<Time,Long> {
    @Transactional
    @Modifying
    @Query("delete from Time t where t.startTime=:startTime")
    public void deleteByStartTime(@Param("startTime")LocalTime startTime);
//
//    @Query("select from Time t where t.startTime=:startTime")
//    public Time findByStartTime(@Param("startTime")LocalTime startTime);
}
