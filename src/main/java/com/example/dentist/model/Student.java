package com.example.dentist.model;


import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;


import java.util.List;

@Entity
@Table(name="student")
public class Student {

@Id
    private String email;
    private String firstName;
    private String lastName;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "student_breakTime",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "time_id"))
    private List<Time> breakTime;

    public Student() {
    }

    public Student(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student(String email, String firstName, String lastName, List<Time> breakTime) {
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

    public List<Time> getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(List<Time> breakTime) {
        this.breakTime = breakTime;
    }
}
