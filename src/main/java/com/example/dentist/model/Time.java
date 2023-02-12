package com.example.dentist.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time_")
public class Time {
    @Id

    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate date;
    @ManyToMany(mappedBy = "breakTime")
    private List<Student> students;
    public Time() {
    }

    public Time(LocalTime startTime, LocalTime endTime, LocalDate date, List<Student> students) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.students = students;
    }

    public Time(LocalTime startTime, LocalTime endTime, LocalDate date) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
    }



    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object obj) {

        if(this==obj) return true;
        if(obj==null ||!(obj instanceof Time)) return false;
        Time t= (Time) obj;

        return t.getDate().compareTo(this.date)==0 && t.getStartTime().compareTo(this.getStartTime())==0&&t.getEndTime().compareTo(this.getEndTime())==0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime,endTime,date);
    }

    @Override
    public String toString() {
        return this.startTime+"";
    }
}
