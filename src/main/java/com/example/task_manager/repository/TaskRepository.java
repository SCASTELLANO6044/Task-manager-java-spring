package com.example.task_manager.repository;

import com.example.task_manager.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
    TaskEntity findById(int id);
    TaskEntity findByName(String name);
}
