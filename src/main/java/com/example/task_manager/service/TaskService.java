package com.example.task_manager.service;

import com.example.task_manager.dto.TaskDTO;

public interface TaskService {

    TaskDTO findById(int id);
}
