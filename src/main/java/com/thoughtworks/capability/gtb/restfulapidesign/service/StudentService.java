package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        Student studentResponse = Student.builder()
                .id(studentRepository.getAllstudentList().size())
                .name(student.getName())
                .gender(student.getGender())
                .note(student.getNote())
                .build();
        studentRepository.addStudent(studentResponse);
        return studentResponse;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteStudent(id);
    }

    public List<Student> getStudentList(String gender) {
        if(gender != null) {
            return studentRepository.getStudentListByGender(gender);
        }
        return studentRepository.getAllstudentList();
    }

    public Student getStudentById(int id) {
        return studentRepository.getStudentById(id);
    }

    public Student updateStudent(int id, Student student) {
        Student updateStudent = Student.builder()
                .id(id)
                .name(student.getName())
                .gender(student.getGender())
                .note(student.getNote())
                .build();
        studentRepository.updateStudent(id, updateStudent);
        return updateStudent;
    }
}
