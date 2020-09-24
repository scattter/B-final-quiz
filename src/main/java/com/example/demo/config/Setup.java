package com.example.demo.config;

import com.example.demo.entity.GroupEntity;
import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import com.example.demo.repository.GroupRepository;
import com.example.demo.repository.TraineeRepository;
import com.example.demo.repository.TrainerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Setup implements ApplicationRunner {

    private final TrainerRepository trainerRepository;
    private final TraineeRepository traineeRepository;
    private final GroupRepository groupRepository;

    public Setup(TrainerRepository trainerRepository, TraineeRepository traineeRepository, GroupRepository groupRepository) {
        this.trainerRepository = trainerRepository;
        this.traineeRepository = traineeRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Trainer trainer = Trainer.builder()
                .name("kang")
                .build();
        Trainee trainee = Trainee.builder()
                .name("name")
                .office("office")
                .email("email@ee.com")
                .github("github")
                .zoomId("zoomId")
                .build();
        this.traineeRepository.save(trainee);
        this.trainerRepository.save(trainer);

        GroupEntity ss = GroupEntity.builder()
                .name("ss")
                .build();
        GroupEntity save = groupRepository.save(ss);
    }
}
