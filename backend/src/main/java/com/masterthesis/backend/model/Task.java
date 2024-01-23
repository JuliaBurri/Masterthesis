package com.masterthesis.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    public long id;
    @NonNull
    private String title;
    private String description;
    private Date dueDate;
    private Priority prio;
}
