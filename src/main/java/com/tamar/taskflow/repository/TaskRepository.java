package com.tamar.taskflow.repository;

import com.tamar.taskflow.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
