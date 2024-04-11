package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.models.DayActivities;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IDayOfActivitiesService {
    void updateName(String nameOfDayActivities,String idOfDayActivities);
    List<DayActivities> listActivities(String schedulesId);

}
