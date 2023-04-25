package com.example.springboot5_restfulapi.controller;

import com.example.springboot5_restfulapi.model.Student;
import com.example.springboot5_restfulapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public List<Student> viewStudentList() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/detail/{id}")
    public Student viewStudentById(@PathVariable(value = "id") Long id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudent(@PathVariable(value = "id") Long id, @RequestBody Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.getReferenceById(id);
            studentRepository.delete(student);
        }
    }
}
