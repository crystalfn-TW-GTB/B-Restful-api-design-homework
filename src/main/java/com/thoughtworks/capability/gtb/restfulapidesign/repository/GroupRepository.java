package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupRepository {
    private final static List<Group> groupList = new ArrayList<>();
    private static final Integer GROUP_COUNT = 6;

    static {
        for (int i = 0; i < GROUP_COUNT; i++) {
            List<Student> studentList = new ArrayList<>();
            Group group = Group.builder()
                    .id(i)
                    .name("Team " + (i + 1))
                    .studentList(studentList)
                    .note("")
                    .build();
            groupList.add(group);
        }
    }

    public List<Group> getGroupList() {
        return groupList;
    }
}
