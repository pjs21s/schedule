package com.sparta.schedule.service;

import com.sparta.schedule.dto.ScheduleRequestDto;
import com.sparta.schedule.dto.ScheduleResponseDto;
import com.sparta.schedule.entity.Schedule;
import com.sparta.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<ScheduleResponseDto> findAll(String workerName, String modifiedDate) {
        return scheduleRepository.findAll(workerName, modifiedDate);
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
        return new ScheduleResponseDto(schedule);
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule schedule = new Schedule(scheduleRequestDto.getTask(), scheduleRequestDto.getWorkerName(), scheduleRequestDto.getPassword());
        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public void deleteSchedule(Long id, String password) {
        int deletedRow = scheduleRepository.deleteSchedule(id, password);
        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + ": 아이디에 맞는 데이터가 없거나 비밀번호가 틀렸습니다.");
        }
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String task, String workerName, String password) {
        if (task == null || workerName  == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "할일과 작업자명은 필수입니다.");
        }

        int updatedRow = scheduleRepository.updateSchedule(id, task, workerName, password);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, id + ": 아이디에 맞는 데이터가 없거나 비밀번호가 틀렸습니다.");
        }

        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(schedule);
    }
}
