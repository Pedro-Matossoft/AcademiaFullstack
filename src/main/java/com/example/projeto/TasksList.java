package com.example.projeto;

import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.time.LocalDate;

@SessionAttributes({"username","TasksLists"})

public class TasksList {
    private Integer id;
    @Size(min=5, max=20)
    private String username;
    @Size(min=5, max=20)
    private String description;
    @DateTimeFormat
    private LocalDate localDate;
    private boolean done;

    public TasksList(Integer id, String username, String description, LocalDate localDate, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.localDate = localDate;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "TasksList{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", localDate=" + localDate +
                ", done=" + done +
                '}';
    }
}