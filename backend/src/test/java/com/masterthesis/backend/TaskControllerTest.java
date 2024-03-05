package com.masterthesis.backend;

import com.masterthesis.backend.controller.TaskController;
import com.masterthesis.backend.model.Priority;
import com.masterthesis.backend.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.description;

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
        assert (this.taskController.getTaskById(2L).getTitle().equals("Have lunch"));
        assert (this.taskController.getTaskById(2L).getDescription().equals("cook noodles"));
    }

    @Test
    public void getPrioritiesTest() {
        assert (Arrays.equals(this.taskController.getPriorities(), Priority.values()));
    }

    @Test
    public void addTaskTest(){
        Task newTask = this.taskController.addTask(new Task("Steal a cat", "It should be an orange one", 60, Priority.HIGH));

        assert (this.taskController.getTaskById(newTask.id).getTitle().equals("Steal a cat"));
        assert (this.taskController.getTaskById(newTask.id).getDescription().equals("It should be an orange one."));
        assert (this.taskController.getTaskById(newTask.id).getDuration().equals(60));
        assert (this.taskController.getTaskById(newTask.id).getPrio().equals(Priority.HIGH));
        assert (this.taskController.getTaskById(newTask.id).getDueDate().equals(LocalDate.now()));
        assert (!this.taskController.getTaskById(newTask.id).isDone());
    }
}
