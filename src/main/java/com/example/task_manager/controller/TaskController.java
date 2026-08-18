package com.example.task_manager.controller;

import com.example.task_manager.dto.TaskDTO;
import com.example.task_manager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Tag(name = "Task", description = "Endpoint for CRUD operations with tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Get task by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDTO> getTaskbyId(@PathVariable String id) {
        TaskDTO taskDTO = taskService.findById(Integer.parseInt(id));
        return new ResponseEntity<>(taskDTO, HttpStatus.OK);
    }
}
