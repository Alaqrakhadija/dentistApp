package com.example.dentist.service;


import com.example.dentist.dto.StudentDTO;
import com.example.dentist.dto.TimeDTO;
import com.example.dentist.model.Student;
import com.example.dentist.model.Time;
import com.example.dentist.repository.StudentRepository;


import com.example.dentist.repository.TimeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    private TimeRepository timeRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository, TimeRepository timeRepository) {
        this.studentRepository = studentRepository;
        this.timeRepository = timeRepository;
    }

    public List<Student> getAvailableStudent(@RequestBody List<Student> students){

        Time supervisorDateTime=new Time(LocalTime.of(13,0,0),
                LocalTime.of(14,0,0),
                LocalDate .now());
        ArrayList list=new ArrayList<>();
//        list.add(new Time(LocalTime.now(),LocalTime.now(),LocalDate.now()));
        for(Student s:students){
            for(Time studentDateTime:s.getBreakTime()){

                if(compare(studentDateTime,supervisorDateTime))
                    list.add(s);



            }
        }




        return list;
    }
    private boolean compare(Time studentDateTime,Time supervisorDateTime){
        if(studentDateTime.getDate().compareTo(supervisorDateTime.getDate())!=0)
            return false;
        if(studentDateTime.getStartTime().compareTo(supervisorDateTime.getStartTime())>0)
            return false;
        if(studentDateTime.getEndTime().compareTo(supervisorDateTime.getEndTime())<0)
            return false;
//if(studentDateTime.getStartTime().compareTo(supervisorDateTime.getEndTime())>=0)
//            return false;
//if(studentDateTime.getEndTime().compareTo(supervisorDateTime.getStartTime())<=0)
//            return false;
        return true;
    }

    public HashMap<Time,Integer> getMostFrequentTime() {
        List<Student> students=studentRepository.findAll();
        HashMap<Time,Integer> map=new HashMap<>();
        for(Student s:students){
            for(Time studentDateTime:s.getBreakTime()){

                map.put(studentDateTime,map.getOrDefault(studentDateTime,0)+1);

            }
        }
//        Map.Entry mostFrequent = Collections.max(map.entrySet(), Map.Entry.comparingByValue());
//        if(mostFrequent.getValue().equals(1))
//            return new Time();

        return   map;
    }

    public Student saveStudent(StudentDTO studentDTO) {
        Student student= modifyStudent(studentDTO);

      return studentRepository.save(student);

    }


    public List<Student> getStudents() {

        return studentRepository.findAll();
    }

    public void deleteStudent(String email) {

     studentRepository.deleteByEmail(email);
    }

    public Student modifyStudent(StudentDTO studentDTO) {

        Student student=new Student(studentDTO.getEmail(),studentDTO.getFirstName(),studentDTO.getLastName());
        List<Time> breakTime=new ArrayList<>();
        for(TimeDTO timeDTO:studentDTO.getBreakTime()){
            LocalTime sTime=timeDTO.getStartTime();
            int duration=timeDTO.getDuration();
           while(duration!=0){
               logger.info(sTime+"");
               breakTime.add(new Time(sTime,sTime.plusMinutes(30),timeDTO.getDate(),new ArrayList<>( Arrays.asList(student))));
duration-=30;
sTime=sTime.plusMinutes(30);
           }

        }
        student.setBreakTime(breakTime);
        return student;
    }
}
