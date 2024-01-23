package com.masterthesis.backend;

import com.masterthesis.backend.controller.TaskController;
import com.masterthesis.backend.model.Category;
import com.masterthesis.backend.model.Priority;
import com.masterthesis.backend.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

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
        assert (this.taskController.getTaskById(1L).getTitle().equals("Make coffee"));
        assert (this.taskController.getTaskById(1L).getDescription().equals("Black no milk"));
    }

    //TODO: Add test for add new Task

    //TODO: Add test for check task / set task to done

    @Test
    public void getPrioritiesTest() {
        assert (Arrays.equals(this.taskController.getPriorities(), Priority.values()));
    }

    @Test
    public void getCategoriesTest() {
        assert (Arrays.equals(this.taskController.getCategories(), Category.values()));
    }

}
