package com.iuh.spring_boot_api.controller;

import com.iuh.spring_boot_api.entity.Student;
import com.iuh.spring_boot_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @GetMapping("/students")
    public List<Student> getAllPerson(){
        return studentService.getAllStudent();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateStudent(student, id);

    }
}
