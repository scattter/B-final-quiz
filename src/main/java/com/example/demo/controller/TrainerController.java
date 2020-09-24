package com.example.demo.controller;

import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import com.example.demo.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("")
    public List<Trainee> getUnGroupedTrainers(@RequestParam(value = "grouped", required = false) boolean grouped) {
        return trainerService.getUnGroupedTrainers(grouped);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainer addNewTrainer(@RequestBody @Valid Trainer trainer) {
        return trainerService.addTrainer(trainer);
    }

    @DeleteMapping("/{trainer_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainerById(@PathVariable Long trainer_id) {
        trainerService.deleteTrainerById(trainer_id);
    }
}
