package com.example.demo.controller;

import com.example.demo.entity.GroupEntity;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public List<GroupEntity> getGroupedInfo() {
        return groupService.getGroupedInfo();
    }


}
