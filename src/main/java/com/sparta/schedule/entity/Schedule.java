package com.sparta.schedule.entity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Schedule {
    private Long id;
    private String task;
    private String workerName;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public Schedule(Long id, String task, String workerName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.task = task;
        this.workerName = workerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Schedule(String task, String workerName, String password) {
        this.task = task;
        this.workerName = workerName;
        this.password = password;
        this.createdAt = LocalDateTime.now();
        this.modifiedAt = LocalDateTime.now();
    }
}
