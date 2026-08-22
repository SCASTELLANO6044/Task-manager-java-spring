package com.example.task_manager.services;

import com.example.task_manager.dto.response.server.TaskResponseServerDTO;
import com.example.task_manager.entities.TaskEntity;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.service.TaskService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceIntegrationTest {

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @Test
    @Order(1)
    @DisplayName("Given missing task ID when find by ID then throw exception")
    void givenMissingTaskId_whenFindById_throwException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findById(999));
    }

    @Test
    @Order(2)
    @DisplayName("Given an existing task ID when find by ID then return a task")
    void findById_whenPersistedTaskExists_returnsMappedTask() {
        TaskEntity entity = new TaskEntity();
        entity.setName("Random Task");
        entity.setContent("No comprar");

        TaskEntity saved = taskRepository.save(entity);

        TaskResponseServerDTO result =
                taskService.findById(Math.toIntExact(saved.getId()));

        Assertions.assertEquals(saved.getName(), result.getName());
        Assertions.assertEquals(saved.getContent(), result.getContent());

        taskRepository.delete(saved);
    }


    @Test
    @Order(3)
    @DisplayName("Given a negative task ID when find by ID then return a task")
    void givenNegativeTaskId_whenFindById_throwException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findById(-1));
    }



}
