package com.example.demo.service;

import com.example.demo.entity.Trainee;
import com.example.demo.repository.TraineeRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraineeServiceTest {

    @Mock
    TraineeRepository traineeRepository;

    private TraineeService traineeService;

    @Nested
    class getUnGroupedTrainees {
        @Nested
        class whenThereHaveUnGroupedTrainees {
            @Test
            void returnUnGroupedTrainer() {
                List<Trainee> trainees = new ArrayList<>();
                trainees.add(Trainee.builder()
                        .name("name")
                        .office("office")
                        .email("email@ee.com")
                        .github("github")
                        .zoomId("zoomId")
                        .build());
                when(traineeRepository.findUnGroupedTrainees(false)).thenReturn(trainees);
                List<Trainee> result = traineeService.getUnGroupedTrainees(false);
                assertThat(result).isEqualTo(trainees);
            }
        }

        @Nested
        class whenThereNotHaveUnGroupedTrainees {
            @Test
            void returnEmptyList() {
                List<Trainee> trainees = new ArrayList<>();
                when(traineeRepository.findUnGroupedTrainees(false)).thenReturn(trainees);
                List<Trainee> result = traineeService.getUnGroupedTrainees(false);
                assertThat(result).isEqualTo(trainees);
            }
        }
    }
}