package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student createStudent(
            @RequestBody Student student) {

        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {

        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(
            @PathVariable Long id) {

        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return service.updateStudent(
                id,
                student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return "Student Deleted Successfully";
    }
}