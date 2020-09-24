package com.example.demo.repository;

import com.example.demo.entity.Trainee;
import com.example.demo.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {

    @Query(nativeQuery = true,value = "select * from trainer where trainer.grouped = ?1")
    List<Trainee> findUnGroupedTrainers(Boolean isGrouped);
}
