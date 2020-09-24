package com.example.demo.controller;

import com.example.demo.entity.Trainee;
import com.example.demo.service.TraineeService;
import com.example.demo.service.TrainerService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(TraineeController.class)
@AutoConfigureMockMvc
class TraineeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    TraineeService traineeService;

    @Nested
    class getUnGroupedTrainees {
        @Nested
        class whenThereHaveUnGroupedTrainees {
            @Test
            void returnUnGroupedTrainer() throws Exception {
                List<Trainee> trainees = new ArrayList<Trainee>();
                trainees.add(Trainee.builder()
                        .name("name")
                        .office("office")
                        .email("email@ee.com")
                        .github("github")
                        .zoomId("zoomId")
                        .build());
                when(traineeService.getUnGroupedTrainees(false)).thenReturn(trainees);
                mockMvc.perform(get("/trainees?grouped=false"))
                        .andExpect(jsonPath("$", hasSize(1)));
            }
        }

        @Nested
        class whenThereNotHaveUnGroupedTrainees {
            @Test
            void returnEmptyList() throws Exception {
                List<Trainee> trainees = new ArrayList<Trainee>();
                when(traineeService.getUnGroupedTrainees(false)).thenReturn(trainees);
                mockMvc.perform(get("/trainees?grouped=false"))
                        .andExpect(jsonPath("$", hasSize(0)));
            }
        }
    }

}