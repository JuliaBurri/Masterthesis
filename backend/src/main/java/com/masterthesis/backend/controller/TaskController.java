package com.masterthesis.backend.controller;

import com.masterthesis.backend.model.Category;
import com.masterthesis.backend.model.Priority;
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
    public List<Task> getAll() {
        return repository.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    //TODO: Add request method to create new task

    //TODO: Add request method to update existing task / set Task to done

    @GetMapping("/tasks/schedule")
    public List<Task> getWorkDaySchedule(@PathVariable Long id) {
        // TODO: Schedule work day with Knappsack algorithm
        // A Work day is 8 hours long, the tasks should fit into this time limit
        // The tasks should be sorted by priority
        // The tasks that not fit into the time limit should not be sent
        return repository.findAll();
    }

    @DeleteMapping("/tasks/{id}")
    void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/tasks/categories")
    public Category[] getCategories() {
        return Category.values();
    }

    @GetMapping("/tasks/priorities")
    public Priority[] getPriorities() {
        return Priority.values();
    }

}
