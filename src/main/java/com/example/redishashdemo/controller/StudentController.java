package com.example.redishashdemo.controller;

import com.example.redishashdemo.model.Student;
import com.example.redishashdemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping("/student/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping("/student/delete/{gradeLevel}")
    public void deleteByGradeLevel(@RequestParam String gradeLevel) {
        Optional<List<Student>> allByGradeLevel = studentRepository.findAllByGradeLevel(gradeLevel);
        allByGradeLevel.ifPresent(studentRepository::deleteAll);
    }
}
