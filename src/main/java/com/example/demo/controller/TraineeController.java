package com.example.demo.controller;

import com.example.demo.entity.Trainee;
import com.example.demo.exception.TraineeNotFoundException;
import com.example.demo.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trainees")
public class TraineeController {
    private final TraineeService traineeService;

    public TraineeController(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("")
    public List<Trainee> getUnGroupedTrainees(@RequestParam(value = "grouped",required = false) boolean grouped) {
        return traineeService.getUnGroupedTrainees(grouped);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Trainee addNewTrainee(@RequestBody @Valid Trainee trainee) {
        return traineeService.addTrainee(trainee);
    }

    @DeleteMapping("/{trainee_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTraineeById(@PathVariable Long trainee_id) throws TraineeNotFoundException {
        traineeService.deleteTraineeById(trainee_id);
    }

}
