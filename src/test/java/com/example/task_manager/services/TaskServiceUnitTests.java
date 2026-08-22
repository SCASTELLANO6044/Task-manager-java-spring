package com.example.task_manager.services;

import com.example.task_manager.dto.response.server.TaskResponseServerDTO;
import com.example.task_manager.entities.TaskEntity;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.service.TaskServiceImpl;
import com.example.task_manager.utils.Mappers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceUnitTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private Mappers mappers;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void findById_whenTaskExists_returnsMappedTask() {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setId(3L);
        taskEntity.setName("Comprar Mantequilla");
        taskEntity.setContent("No comprar");

        TaskResponseServerDTO taskResponseServerDTO = new TaskResponseServerDTO();
        taskResponseServerDTO.setName("Comprar Mantequilla");
        taskResponseServerDTO.setContent("No comprar");

        when(taskRepository.findById(3)).thenReturn(taskEntity);
        when(mappers.map(taskEntity, TaskResponseServerDTO.class)).thenReturn(taskResponseServerDTO);

        TaskResponseServerDTO result = taskService.findById(3);

        assertNotNull(result);
        assertEquals("Comprar Mantequilla", result.getName());
        assertEquals("No comprar", result.getContent());

        verify(taskRepository).findById(3);
    }

    @Test
    void findById_whenTaskDoesNotExist_throwsException() {
        verifyNoInteractions(mappers);
        when(taskRepository.findById(999)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> taskService.findById(999));
    }

    @Test
    void findById_whenIdIsNegative_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> taskService.findById(-1));
        verifyNoInteractions(taskRepository, mappers);
    }
}