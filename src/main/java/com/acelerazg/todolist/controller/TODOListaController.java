package com.acelerazg.todolist.controller;

import com.acelerazg.todolist.dto.TaskDto;
import com.acelerazg.todolist.entities.Task;
import com.acelerazg.todolist.service.impl.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TODOListaController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody @Valid TaskDto dto){
        TaskDto createTask = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid TaskDto dto){
        service.update(dto, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable("id") Long id){
        Optional<Task> taskById = service.findById(id);
        return taskById.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(taskById.get());
    }

    @GetMapping
    public ResponseEntity<Page<Task>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/findAll/{status}")
    public ResponseEntity<List<TaskDto>> findAllByStatus(@PathVariable("status") Long status){
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @GetMapping("/findAll/{category}")
    public ResponseEntity<List<TaskDto>> findAllByCategory(@PathVariable("category") Long category){
        return ResponseEntity.ok(service.findByCategory(category));
    }

    @GetMapping("/findAll/{priority}")
    public ResponseEntity<List<TaskDto>> findAllByPriority(@PathVariable("priority") Long priority){
        return ResponseEntity.ok(service.findByPriority(priority));
    }
}
