package com.iuh.spring_boot_api.service;

import com.iuh.spring_boot_api.entity.Student;
import com.iuh.spring_boot_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService{

    private StudentRepository studentRepository;


    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
       return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {
        Optional<Student> result = studentRepository.findById(id);
        Student theStudent = null;
        if (result.isPresent()) {
            theStudent = result.get(); }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return theStudent; }

    @Override
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Student studentTemp, int id) {
        Student student = studentRepository.getById(id);
        student.setName(studentTemp.getName());
        student.setScore(studentTemp.getScore());
        studentRepository.save(student);
    }

}
