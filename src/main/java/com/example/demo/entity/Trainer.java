package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "name can't be null")
    private String name;
    @JsonIgnore
    @Builder.Default
    private boolean grouped = false;

    @Column(name = "groups_id")
    private Long groupsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groups_id", insertable = false, updatable = false)
    private GroupEntity groups;
}
