package com.example.demo.exception;

public class TraineeOrTrainerNotFoundException extends RuntimeException {
    public TraineeOrTrainerNotFoundException(String message) {
        super(message);
    }
}
