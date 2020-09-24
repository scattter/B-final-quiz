package com.example.demo.service;

import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;

    public GroupService(GroupRepository groupRepository, TrainerRepository trainerRepository, TraineeRepository traineeRepository) {
        this.groupRepository = groupRepository;
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
    }

    public List<GroupEntity> getGroupedInfo() {
        return groupRepository.findAll();
    }
}
