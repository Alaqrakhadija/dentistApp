package com.example.dentist.dto;

import com.example.dentist.model.Time;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class StudentDTO {
    private String email;
    private String firstName;
    private String lastName;

    private List<TimeDTO> breakTime;

    public StudentDTO() {
    }

    public StudentDTO(String email, String firstName, String lastName, List<TimeDTO> breakTime) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.breakTime = breakTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<TimeDTO> getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(List<TimeDTO> breakTime) {
        this.breakTime = breakTime;
    }
}
