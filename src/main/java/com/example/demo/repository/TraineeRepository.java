package com.example.demo.repository;

import com.example.demo.entity.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long> {

    @Query(nativeQuery = true,value = "select * from trainee where trainee.grouped = ?1")
    List<Trainee> findUnGroupedTrainees(Boolean isGrouped);
}
