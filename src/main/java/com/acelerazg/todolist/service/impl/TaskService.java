package com.acelerazg.todolist.service.impl;

import com.acelerazg.todolist.dto.TaskDto;
import com.acelerazg.todolist.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    TaskDto create(TaskDto dto);
    void update(TaskDto dto, Long id);
    void delete(Long id);
    Optional<Task> findById(Long id);
    Page<Task> findAll(Pageable pageable);
    List<TaskDto> findByStatus(Long statusId);
    List<TaskDto> findByPriority(Long priority);
    List<TaskDto> findByCategory(Long category);


}
