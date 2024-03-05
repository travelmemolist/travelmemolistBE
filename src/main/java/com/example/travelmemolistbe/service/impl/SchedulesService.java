package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.Schedules;
import com.example.travelmemolistbe.repository.IDayActiviesRepository;
import com.example.travelmemolistbe.repository.ISchedulesRepository;
import com.example.travelmemolistbe.service.ISchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;

@Service
public class SchedulesService implements ISchedulesService {
    @Autowired
    private ISchedulesRepository ichedulesRepository;
    @Autowired
    private IDayActiviesRepository iDayActiviesRepository;

    @Override
    public Page<Schedules> findAllSchedulesByUserId(Pageable page, String id,String titleSchedules) {
        Page<Schedules> findAllSchedulesByUserId = ichedulesRepository.selectAllSchedules(page,id,titleSchedules);
        return findAllSchedulesByUserId;
    }

    @Override
    public void createSchedules(Integer id,String title, String description, String address, Date startDay, Date endDay, Long userId) {
        String day = "Ngày ";
        ichedulesRepository.createSchedule(title, description, address, startDay, endDay, userId);
        Long totalDayHasBeenCreater = caculateDay(startDay,endDay);
        for (int i = 1; i <= totalDayHasBeenCreater; i++) {
            iDayActiviesRepository.createDayAtivities(startDay,day + i,"",id);
            long timeByMiliSecond = startDay.getTime();
            timeByMiliSecond += 1 * 24 * 60 * 60 * 1000;
            startDay.setTime(timeByMiliSecond);
        }
    }

    @Override
    public Long caculateDay(Date startDay, Date endDay) {
        return Duration.between(startDay.toInstant(), endDay.toInstant()).toDays();
    }


}
