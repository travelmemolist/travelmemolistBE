package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.Schedules;
import com.example.travelmemolistbe.repository.ISchedulesRepository;
import com.example.travelmemolistbe.service.ISchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SchedulesService implements ISchedulesService {
    @Autowired
    private ISchedulesRepository ichedulesRepository;
    @Override
    public Page<Schedules> findAllSchedulesByUserId(Pageable page, String id,String titleSchedules) {
        Page<Schedules> findAllSchedulesByUserId = ichedulesRepository.selectAllSchedules(page,id,titleSchedules);
        return findAllSchedulesByUserId;
    }
}
