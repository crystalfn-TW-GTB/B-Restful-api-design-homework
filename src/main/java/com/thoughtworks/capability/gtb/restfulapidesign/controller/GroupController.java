package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public List<Group> group() {
        return groupService.group();
    }

    @PatchMapping("/{id}")
    public Group updateGroupName(@PathVariable Integer id,
                                 @RequestBody String name){
        return groupService.updateGroupName(id, name);
    }

    @GetMapping
    public List<Group> getGroupList() {
        return groupService.getGroupList();
    }
}
