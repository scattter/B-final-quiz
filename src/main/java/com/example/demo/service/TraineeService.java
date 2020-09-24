package com.example.demo.service;

import com.example.demo.entity.Trainee;
import com.example.demo.exception.TraineeNotFoundException;
import com.example.demo.repository.TraineeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeService {
    private final TraineeRepository traineeRepository;

    public TraineeService(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    public Trainee addTrainee(Trainee trainee) {
        traineeRepository.save(trainee);
        return trainee;
    }

    public void deleteTraineeById(Long id) throws TraineeNotFoundException {
        Optional<Trainee> result = traineeRepository.findById(id);
        if(!result.isPresent()){
            throw new TraineeNotFoundException("Trainee Not Found");
        }
        traineeRepository.deleteById(id);
    }

    public List<Trainee> getUnGroupedTrainees(Boolean isGrouped) {
        return this.traineeRepository.findUnGroupedTrainees(isGrouped);
    }
}
