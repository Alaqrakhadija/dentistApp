package com.example.dentist.service;

import com.example.dentist.dto.TimeDTO;
import com.example.dentist.model.Time;
import com.example.dentist.repository.StudentRepository;
import com.example.dentist.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeService {
    private TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void deleteTime(LocalTime startTime) {

       timeRepository.deleteByStartTime(startTime);
    }

    public List<TimeDTO> getTime() {
        List<Time> times=timeRepository.findAll();
        List<TimeDTO> timeDTOS=new ArrayList<>();
        for(Time time:times){
            timeDTOS.add(new TimeDTO(time.getStartTime(),30,time.getDate()));
        }
        return timeDTOS;
    }
}
