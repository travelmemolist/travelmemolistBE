package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.dto.CreateSchdules;
import com.example.travelmemolistbe.models.Schedules;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface ISchedulesService {
    Page<Schedules> findAllSchedulesByUserId(Pageable page,String id,String titleSchedules);
    Schedules createSchedules(Schedules s);
//    String title, String description, String address, Date startDay, Date endDay, Long user_user_id
    Long caculateDay(Date startDay, Date endDay);

    void updateStatus(String schedulesId);
}
