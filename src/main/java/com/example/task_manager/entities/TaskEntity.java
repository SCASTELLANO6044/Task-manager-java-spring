package com.example.task_manager.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "content")
    private String content;
}
