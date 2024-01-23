package com.masterthesis.backend.controller;

import com.masterthesis.backend.model.Appointment;
import com.masterthesis.backend.repository.AppointmentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class AppointmentController {
    private final AppointmentRepository repository;

    AppointmentController(AppointmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/appointments")
    List<Appointment> getAll() {
        return repository.findAll();
    }

}
