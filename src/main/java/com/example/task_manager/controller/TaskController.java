package com.example.task_manager.controller;

import com.example.task_manager.dto.request.server.TaskRequestServerDTO;
import com.example.task_manager.dto.response.server.TaskResponseServerDTO;
import com.example.task_manager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@Tag(name = "Task", description = "Endpoint for CRUD operations with tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Operation(summary = "Get task by id")
    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseServerDTO> getTaskById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.findById(Integer.parseInt(id)), HttpStatus.OK);
    }

    @Operation(summary = "Create task")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskResponseServerDTO> createTask(@RequestBody TaskRequestServerDTO taskRequestServerDTO) {
        return new ResponseEntity<>(taskService.createTask(taskRequestServerDTO), HttpStatus.CREATED);
    }
}
