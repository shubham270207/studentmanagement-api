package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Student updateStudent(Long id,
                                 Student student) {

        Student existing =
                repository.findById(id)
                        .orElse(null);

        if (existing != null) {

            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setAge(student.getAge());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}