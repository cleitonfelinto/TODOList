package com.acelerazg.todolist.service.impl;

import com.acelerazg.todolist.dto.TaskDto;
import com.acelerazg.todolist.entities.Task;
import com.acelerazg.todolist.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository repository;

    private ModelMapper modelMapper;

    @Override
    public TaskDto create(TaskDto dto) {
        Task task = Task.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .endDate(dto.getEndDate())
                .status(dto.getStatus())
                .category(dto.getCategory())
                .priority(dto.getPriority())
                .build();
        repository.saveAndFlush(task);
        return modelMapper.map(task, TaskDto.class);
    }

    @Override
    public void update(TaskDto dto, Long id) {
        Optional<Task> taskId = findById(id);
        var task = taskId.get();
        task.setName(dto.getName());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setCategory(dto.getCategory());
        task.setEndDate(dto.getEndDate());
        task.setStatus(dto.getStatus());
        repository.saveAndFlush(task);
    }

    @Override
    public void delete(Long id){
        var task = findById(id);
        if(task.isEmpty()){
            throw new NullPointerException("Task not found");
        }
        repository.delete(task.get());
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<TaskDto> findByStatus(Long statusId) {
        List<Task> tasksByStatus = repository.findByStatus(statusId);
        List<TaskDto> list = new ArrayList<>();
        if (tasksByStatus != null && !tasksByStatus.isEmpty()){
            list = tasksByStatus
                    .stream()
                    .map(t -> modelMapper.map(t, TaskDto.class))
                    .collect(Collectors.toList());
        }
        return list;
    }

    @Override
    public List<TaskDto> findByPriority(Long priority) {
        List<Task> tasksByPriority = repository.findByPriority(priority);
        List<TaskDto> list = new ArrayList<>();
        if (tasksByPriority != null && !tasksByPriority.isEmpty()){
            list = tasksByPriority
                    .stream()
                    .map(t -> modelMapper.map(t, TaskDto.class))
                    .collect(Collectors.toList());
        }
        return list;
    }

    @Override
    public List<TaskDto> findByCategory(Long category) {
        List<Task> tasksByCategory = repository.findByCategory(category);
        List<TaskDto> list = new ArrayList<>();
        if (tasksByCategory != null && !tasksByCategory.isEmpty()){
            list = tasksByCategory
                    .stream()
                    .map(t -> modelMapper.map(t, TaskDto.class))
                    .collect(Collectors.toList());
        }
        return list;
    }
}
