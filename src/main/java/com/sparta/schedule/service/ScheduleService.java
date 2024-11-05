package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {
    List<ScheduleResponseDto> findAll(String workerName, String modifiedDate);

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto);
}
