package com.iuh.spring_boot_api.service;

import com.iuh.spring_boot_api.entity.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudent(int id);
    public void deleteStudent(int id);
    public void updateStudent(Student studentTemp, int id);
}
