package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.dto.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        Student studentResponse = Student.builder()
                .id(studentRepository.getAllstudentList().size() + 1)
                .name(student.getName())
                .gender(student.getGender())
                .note(student.getNote())
                .build();
        studentRepository.addStudent(studentResponse);
        return studentResponse;
    }
}
