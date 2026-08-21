package com.example.task_manager.services;

import com.example.task_manager.dto.response.server.TaskResponseServerDTO;
import com.example.task_manager.service.TaskService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceTest {

    @Autowired
    TaskService taskService;

    TaskResponseServerDTO taskResponseServerDTO;

    @BeforeAll
    void setup(){
        this.taskResponseServerDTO = new TaskResponseServerDTO();
        this.taskResponseServerDTO.setName("Comprar Mantequilla");
        this.taskResponseServerDTO.setContent("No comprar");
    }

    @Test
    @Order(1)
    @DisplayName("Given missing task ID when find by ID then throw exception")
    void givenMissingTaskId_whenFindById_throwException() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.findById(999);
        });
    }

    @Test
    @Order(2)
    @DisplayName("Given an existing task ID when find by ID then return a task")
    void givenExistingTaskId_whenFindById_returnTask() {
        TaskResponseServerDTO task = taskService.findById(3);
        Assertions.assertNotNull(task);
        Assertions.assertEquals("Comprar Mantequilla", task.getName());
        Assertions.assertEquals("No comprar", task.getContent());
    }


    @Test
    @Order(3)
    @DisplayName("Given an existing task ID when find by ID then return a task")
    void givenNegativeTaskId_whenFindById_throwException() {
        assertThrows(IllegalArgumentException.class, () -> {
            taskService.findById(-1);
        });
    }



}
