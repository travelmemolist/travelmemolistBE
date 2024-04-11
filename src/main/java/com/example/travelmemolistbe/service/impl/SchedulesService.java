package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.DayActivities;
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
import java.util.List;

@Service
public class SchedulesService implements ISchedulesService {
    @Autowired
    private ISchedulesRepository schedulesRepository;
    @Autowired
    private IDayActiviesRepository iDayActiviesRepository;

    @Override
    public Page<Schedules> findAllSchedulesByUserId(Pageable page, Long id, String titleSchedules) {
        Page<Schedules> findAllSchedulesByUserId = schedulesRepository.selectAllSchedules(id, titleSchedules, page);
        return findAllSchedulesByUserId;
    }

    @Override
    public Schedules createSchedules(Schedules schedules) {
        String day = "Ngày ";
        Schedules s = schedulesRepository.save(schedules);
        Long totalDayHasBeenCreater = caculateDay(s.getStartDay(), s.getEndDay());
        if (totalDayHasBeenCreater <= 1) {
            iDayActiviesRepository.createDayAtivities(s.getStartDay(), day + "1", "", s.getSchedulesId());
        }
        Date today = s.getStartDay();
        for (int i = 1; i <= totalDayHasBeenCreater; i++) {
            iDayActiviesRepository.createDayAtivities(today, day + i, "", s.getSchedulesId());
            today = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        }
        return s;
    }


    @Override
    public Long caculateDay(Date startDay, Date endDay) {
        return Duration.between(startDay.toInstant(), endDay.toInstant()).toDays();
    }

    @Override
    public void updateStatus(String schedulesID) {
        schedulesRepository.updateStatusSchedules(schedulesID);
    }

    @Override
    public List<DayActivities> getDayActivitiesByScheduleId(Long scheduleId) {
        return iDayActiviesRepository.findByScheduleSchedulesId(scheduleId);
    }
}