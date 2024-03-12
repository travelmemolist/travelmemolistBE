package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.models.Activities;
import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.repository.IActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IActivitiesService {
    void saveActivities(Activities activities);
    Activities findActivityById(Long activityId);
    List<Activities> findAllActivitiesByDayActivities(int idDayActivities);

    void updateActivities(String activityName,String description,String endTime,String startTime,String activityId);
    void deleteActivities(String id);

}
