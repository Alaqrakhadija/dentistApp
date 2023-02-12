package com.example.dentist.controller;


import com.example.dentist.dto.StudentDTO;
import com.example.dentist.dto.TimeDTO;
import com.example.dentist.model.Student;
import com.example.dentist.model.Time;
import com.example.dentist.service.StudentService;
import com.example.dentist.service.TimeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/time")
public class TimeController {
    private TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @DeleteMapping("/{id}")
    public Object deleteTime(@PathVariable(name = "id") LocalTime id){
   timeService.deleteTime(id);
   return "deleted";

    }
    @GetMapping
    public List<TimeDTO> getTime(){
      return  timeService.getTime();


    }
}
