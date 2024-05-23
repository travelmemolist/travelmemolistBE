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
    private ISchedulesRepository ichedulesRepository;
    @Autowired
    private IDayActiviesRepository iDayActiviesRepository;

    @Override
    public Page<Schedules> findAllSchedulesByUserId(Pageable page, Long id,String titleSchedules) {
        Page<Schedules> findAllSchedulesByUserId = ichedulesRepository.selectAllSchedules(id,titleSchedules,page);
        return findAllSchedulesByUserId;
    }

    @Override
    public Page<Schedules> findAllCompletedSchedules(Pageable page, Long id, String titleSchedules) {
        Page<Schedules> findAllCompletedSchedules = ichedulesRepository.selectAllCompletedSchedules(id,titleSchedules,page);
        return findAllCompletedSchedules;
    }

    @Override
    public Schedules createSchedules(Schedules schedules) {
        String day = "Ngày ";
        Schedules s = ichedulesRepository.save(schedules);
        Long totalDayHasBeenCreater = caculateDay(s.getStartDay(),s.getEndDay());
        Date date = new Date();
        date.setTime(s.getStartDay().getTime());
        for (int i = 1; i <= totalDayHasBeenCreater; i++) {
            iDayActiviesRepository.createDayAtivities(date,day + i,"",s.getSchedulesId());
            long timeByMiliSecond = date.getTime();
            timeByMiliSecond += 1 * 24 * 60 * 60 * 1000;
            date.setTime(timeByMiliSecond);
        }
        return s;
    }

    @Override
    public Long caculateDay(Date startDay, Date endDay) {
        return Duration.between(startDay.toInstant(), endDay.toInstant()).toDays();
    }

    @Override
    public void updateStatus(String schedulesID) {
        ichedulesRepository.updateStatusSchedules(schedulesID);
    }

    @Override
    public List<DayActivities> getDayActivitiesByScheduleId(Long scheduleId) {
        return iDayActiviesRepository.findByScheduleSchedulesId(scheduleId);
    }
}