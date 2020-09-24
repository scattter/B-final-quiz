package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainee")
public class Trainee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name can't be null")
    private String name;
    @NotEmpty(message = "office can't be null")
    private String office;
    @Email
    private String email;
    @NotEmpty(message = "github can't be null")
    private String github;
    @NotEmpty(message = "zoomId can't be null")
    private String zoomId;

    @JsonIgnore
    @Builder.Default
    private boolean grouped = false;

}
