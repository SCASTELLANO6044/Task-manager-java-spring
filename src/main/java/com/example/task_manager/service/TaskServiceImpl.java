package com.example.task_manager.service;

import com.example.task_manager.dto.request.server.TaskRequestServerDTO;
import com.example.task_manager.dto.response.server.TaskResponseServerDTO;
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
    public TaskResponseServerDTO findById(int id) {
        TaskEntity taskEntity = taskRepository.findById(id);
        TaskResponseServerDTO taskResponseServerDTO = mappers.map(taskEntity, TaskResponseServerDTO.class);
        return mappers.map(taskResponseServerDTO, TaskResponseServerDTO.class);
    }

    @Override
    public TaskResponseServerDTO createTask(TaskRequestServerDTO taskRequestServerDTO) {
        TaskEntity taskEntity = mappers.map(taskRequestServerDTO, TaskEntity.class);
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return mappers.map(savedTaskEntity, TaskResponseServerDTO.class);
    }
}
