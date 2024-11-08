package com.sparta.schedule.repository;

import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    List<ScheduleResponseDto> findAll(String workerName, String modifiedDate);

    Schedule findScheduleByIdOrElseThrow(Long id);

    ScheduleResponseDto saveSchedule(Schedule schedule);

    int deleteSchedule(Long id, String password);

    int updateSchedule(Long id, String task, String workerName, String password);
}
