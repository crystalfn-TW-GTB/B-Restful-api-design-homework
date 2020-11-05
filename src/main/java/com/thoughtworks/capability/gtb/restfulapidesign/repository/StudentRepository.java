package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private static final List<Student> studentList = new ArrayList<>();

    public List<Student> getAllstudentList() {
        return studentList;
    }

    public List<Student> getStudentListByGender(String genger) {
        return studentList
                .stream()
                .filter((student -> genger.equals(student.getGender())))
                .collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void deleteStudent(int id) {
        studentList.remove(id);
    }

    public Student getStudentById(int id) {
        return studentList.get(id);
    }

    public void updateStudent(int id, Student updateStudent) {
        Student student = studentList.get(id);
        student.setName(updateStudent.getName());
        student.setGender(updateStudent.getGender());
        student.setNote(updateStudent.getNote());
    }
}
