package com.acelerazg.todolist.repository;

import com.acelerazg.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT t FROM Task t WHERE t.status = :statusId")
    public List<Task> findByStatus(@Param("statusId") Long statusId);

    @Query(value = "SELECT t FROM Task t WHERE t.priority = :priority")
    public List<Task> findByPriority(@Param("priority") Long priority);

    @Query(value = "SELECT t FROM Task t WHERE t.category = :category")
    public List<Task> findByCategory(@Param("category") Long category);

}
