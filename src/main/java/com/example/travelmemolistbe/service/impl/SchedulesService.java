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
    public Schedules createSchedules(Schedules schedules) {
        String day = "Ngày ";
//        Schedules schedules = ichedulesRepository.createSchedule(title, description, address, startDay, endDay, userId);
//        ichedulesRepository.createSchedule(schedules.getTitle(),schedules.getDescription(),schedules.getAddress(),schedules.getStartDay(),schedules.getEndDay(),schedules.getUserId());
        Schedules s = ichedulesRepository.save(schedules);
        Long totalDayHasBeenCreater = caculateDay(s.getStartDay(),s.getEndDay());
        for (int i = 1; i <= totalDayHasBeenCreater; i++) {
            iDayActiviesRepository.createDayAtivities(s.getStartDay(),day + i,"",s.getSchedulesId());
            long timeByMiliSecond = s.getStartDay().getTime();
            timeByMiliSecond += 1 * 24 * 60 * 60 * 1000;
            schedules.getStartDay().setTime(timeByMiliSecond);
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
