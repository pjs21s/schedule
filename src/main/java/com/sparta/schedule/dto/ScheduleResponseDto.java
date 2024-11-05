package com.sparta.schedule.dto;

import com.sparta.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String task;
    private String workerName;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.task = schedule.getTask();
        this.workerName = schedule.getWorkerName();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }

    public ScheduleResponseDto(Long id, String task, String workerName, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.task = task;
        this.workerName = workerName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
