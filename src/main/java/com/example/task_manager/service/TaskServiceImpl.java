package com.example.task_manager.service;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.entities.TaskEntity;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.utils.Mappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    Mappers mappers;

    @Override
    public TaskDTO findById(int id) {
        TaskEntity taskEntity = taskRepository.findById(id);
        return mappers.map(taskEntity, TaskDTO.class);
    }
}
