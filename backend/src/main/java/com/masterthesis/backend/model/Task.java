package com.masterthesis.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

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
    private Integer duration;
    private LocalDate dueDate;
    private Priority prio;
    private boolean done;

    public Task(String title, String description, Integer duration, Priority prio) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.prio = prio;
    }

    public boolean isTaskVerified(){

        if(!this.isDone() && this.getTitle() != null && this.getDescription() != null && this.getDuration() != null && this.getPrio() != null){
            return true;
        }
        return false;
    }
}
