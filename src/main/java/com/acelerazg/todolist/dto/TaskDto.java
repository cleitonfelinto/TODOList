package com.acelerazg.todolist.dto;

import com.acelerazg.todolist.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {

    private Long id;

    private String name;

    private String description;

    private LocalDate endDate;

    private Long priority;

    private StatusEnum status;

    private String category;
}
