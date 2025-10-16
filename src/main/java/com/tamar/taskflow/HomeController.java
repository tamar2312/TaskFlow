package com.tamar.taskflow;

import com.tamar.taskflow.models.Task;
import com.tamar.taskflow.models.TaskRequest;
import com.tamar.taskflow.models.User;
import com.tamar.taskflow.repository.TaskRepository;
import com.tamar.taskflow.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class HomeController {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public HomeController(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public List<Task> findUserTasks(@PathVariable Long id){
        return  taskRepository.findByOwnerId(id);
    }

    @PostMapping
    public Task create(@RequestBody TaskRequest Request) {
        User owner = userRepository.findById(Request.getOwnerId()).orElseThrow(() -> new RuntimeException("Task not found"));
        Task task = new Task();
        task.setUser(owner);
        task.setTitle(Request.getTitle());
        task.setStatus(Request.getStatus());
        task.setDescription(Request.getDescription());

        return taskRepository.save(task);
    }

    @PutMapping("/{id}/status")
    public Task updateStatus(@PathVariable Long id, @RequestBody String newStatus) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));

        task.setStatus(newStatus);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
