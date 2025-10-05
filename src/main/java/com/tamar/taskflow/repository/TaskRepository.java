package com.tamar.taskflow.repository;

import com.tamar.taskflow.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByOwnerId(Long ownerId);
}
