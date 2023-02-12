package com.example.dentist.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeDTO {
    private LocalTime startTime;
    private int duration;
    private LocalDate date;

    public TimeDTO() {
    }

    public TimeDTO(LocalTime startTime, int duration, LocalDate date) {
        this.startTime = startTime;
        this.duration = duration;
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
}}
