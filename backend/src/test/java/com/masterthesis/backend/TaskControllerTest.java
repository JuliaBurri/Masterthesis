package com.masterthesis.backend;

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
    public void getPrioritiesTest() {
        assert (Arrays.equals(this.taskController.getPriorities(), Priority.values()));
    }

    @Test
    public void createTaskTest() {
        //given
        Task task = new Task("test task", "this is a description", 30, Priority.HIGH);
        //when
        Task createdTask = taskController.createTask(task);
        //then
        assert (!createdTask.isDone());
        assert (createdTask.getDueDate().equals(LocalDate.now()));
        assert (createdTask.getTitle().equals(task.getTitle()));
    }
}
