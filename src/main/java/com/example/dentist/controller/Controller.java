package com.example.dentist.controller;


import com.example.dentist.dto.StudentDTO;
import com.example.dentist.dto.TimeDTO;
import com.example.dentist.model.Student;
import com.example.dentist.model.Time;
import com.example.dentist.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/student")
public class Controller {

    private StudentService studentService;
    public Controller(StudentService studentService) {
        this.studentService = studentService;
    }


    //    @PostMapping
//    public List<Student> getAvailableStudent(@RequestBody List<Student> students){
//        return studentService.getAvailableStudent(students);
//    }
    @GetMapping("/AvailableTime")
    public Object getMostFrequentTime(){
        return studentService.getMostFrequentTime();
    }
    @PostMapping
    public Object saveStudent(@RequestBody StudentDTO studentDTO){


        studentService.saveStudent(studentDTO);
        return studentDTO;
    }
    @DeleteMapping("/{id}")
    public Object deleteStudent(@PathVariable(name = "id") String email){
       studentService.deleteStudent(email);
        return "deleted";
    }
}
