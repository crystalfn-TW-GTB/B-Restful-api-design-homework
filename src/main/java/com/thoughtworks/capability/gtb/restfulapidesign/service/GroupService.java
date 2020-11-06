package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.GroupRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    final GroupRepository groupRepository;
    final StudentRepository studentRepository;
    private static final Integer GROUP_COUNT = 6;

    public GroupService(GroupRepository groupRepository,
                        StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> group() {
        List<Student> allstudentList = studentRepository.getAllstudentList();
        List<Student> shuffleStudentList = new ArrayList<>(allstudentList);
        Collections.shuffle(shuffleStudentList);

        List<Group> groupList = groupRepository.getGroupList();
        resetGroupList(groupList);

        for (int i = 0; i < shuffleStudentList.size(); i++) {
            List<Student> studentList = groupList.get(i % GROUP_COUNT).getStudentList();
            studentList.add(shuffleStudentList.get(i));
        }

        return groupList;
    }

    private void resetGroupList(List<Group> groupList) {
        for (int i = 0; i < groupList.size(); i++) {
            List<Student> studentList = new ArrayList<>();
            Group newGroup = Group.builder()
                    .id(groupList.get(i).getId())
                    .name(groupList.get(i).getName())
                    .studentList(studentList)
                    .note(groupList.get(i).getNote())
                    .build();
            groupList.set(i, newGroup);
        }
    }

    public Group updateGroupName(int id, String name) {
        Group group = groupRepository.getGroupList().get(id);
        group.setName(name);
        return group;
    }
}
