package com.acelerazg.todolist.entities;

import com.acelerazg.todolist.enums.StatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "end_date")
    @NotNull
    private LocalDate endDate;

    @Size(min = 1, max = 5)
    @Column(name = "priority")
    @NotNull
    private Long priority;

    @Column(name = "status")
    @NotNull
    private StatusEnum status;

    @Column(name = "category")
    private String category;
}
