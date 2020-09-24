package com.example.demo.service;

import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import com.example.demo.exception.TraineeOrTrainerNotFoundException;
import com.example.demo.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainee> getUnGroupedTrainers(boolean grouped) {
        return trainerRepository.findUnGroupedTrainers(grouped);
    }

    public Trainer addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
        return trainer;
    }

    public void deleteTrainerById(Long trainer_id) {
        if(!trainerRepository.findById(trainer_id).isPresent()){
            throw new TraineeOrTrainerNotFoundException("Trainer Not Found");
        }
        trainerRepository.deleteById(trainer_id);
    }
}
