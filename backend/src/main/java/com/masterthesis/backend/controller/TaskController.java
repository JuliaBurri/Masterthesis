package com.masterthesis.backend.controller;

import com.masterthesis.backend.repository.TaskRepository;
import com.masterthesis.backend.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TaskController {
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    List<Task> getAll() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    Task getTaskById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    @PostMapping("/tasks")
    Task newTask(@RequestBody Task newTask) {
        return repository.save(newTask);
    }

    @PutMapping("/task/{id}")
    Task replaceTask(@RequestBody Task newTask, @PathVariable Long id) {

        return repository.findById(id)
                .map(task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setDueDate(newTask.getDueDate());
                    task.setPrio(newTask.getPrio());
                    return repository.save(task);
                })
                .orElseGet(() -> repository.save(newTask));
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
