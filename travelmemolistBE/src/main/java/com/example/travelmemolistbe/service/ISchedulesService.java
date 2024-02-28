package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.models.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ISchedulesService {
    Page<Schedules> findAllSchedulesByUserId(Pageable page,String id,String titleSchedules);
}
