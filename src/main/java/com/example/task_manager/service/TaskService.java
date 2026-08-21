package com.example.task_manager.service;

import com.example.task_manager.dto.request.server.TaskRequestServerDTO;
import com.example.task_manager.dto.response.server.TaskResponseServerDTO;

public interface TaskService {

    TaskResponseServerDTO findById(int id);
    TaskResponseServerDTO createTask(TaskRequestServerDTO taskRequestServerDTO);
    void deleteTask(int id);
}
