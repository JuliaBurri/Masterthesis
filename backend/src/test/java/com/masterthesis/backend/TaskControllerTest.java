package com.masterthesis.backend;

import static com.masterthesis.backend.model.Priority.HIGH;

import com.masterthesis.backend.controller.TaskController;
import com.masterthesis.backend.model.Priority;
import com.masterthesis.backend.model.Task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = BackendApplication.class)
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private TaskController taskController;

    @Test
    public void getAllIsNotEmpty() {
        assert (!this.taskController.getAll().isEmpty());
    }

    @Test
    public void getTaskByIdTest() {
        assert (this.taskController.getTaskById(102L).getTitle().equals("Have lunch"));
        assert (this.taskController.getTaskById(102L).getDescription().equals("cook noodles"));
    }

    @Test
    public void addTask() {
        long newlyCreatedTaskId = this.taskController.addTask(
                new Task(
                        "Title",
                        "Description",
                        10,
                        HIGH
                )
        );
        Task createdTask = this.taskController.getTaskById(newlyCreatedTaskId);
        assert (createdTask.getTitle().equals("Title"));
        assert (createdTask.getDescription().equals("Description"));
        assert (createdTask.getDuration().equals(10));
        assert (createdTask.getPrio().equals(HIGH));
        assert (createdTask.getDueDate().equals(LocalDate.now()));
        assert (Long.valueOf(createdTask.getId()).equals(newlyCreatedTaskId));
        assert (Boolean.valueOf(createdTask.isDone()).equals(false));
    }

    @Test
    public void getPrioritiesTest() {
        assert (Arrays.equals(this.taskController.getPriorities(), Priority.values()));
    }
}
