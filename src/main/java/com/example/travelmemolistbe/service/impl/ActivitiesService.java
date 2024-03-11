package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.Activities;
import com.example.travelmemolistbe.repository.IActivitiesRepository;
import com.example.travelmemolistbe.service.IActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesService implements IActivitiesService {
    @Autowired
    private IActivitiesRepository iActivitiesRepository;
    @Override
    public void saveActivities(Activities activities) {
        iActivitiesRepository.createActivities(activities.getActivityName(),activities.getEndTime(),activities.getStartTime(),activities.getDayActivities().getIdDayActivities());
    }

    @Override
    public List<Activities> findAllActivitiesByDayActivities(int idDayActivities) {
        return iActivitiesRepository.findAllActivitiesByDayActivities(idDayActivities);
    }

    @Override
    public void updateActivities(String activityName, String description, String endTime, String startTime, String activityId) {
        iActivitiesRepository.updateActivity(activityName, description, endTime, startTime, activityId);
    }

    @Override
    public void deleteActivities(String id) {
        iActivitiesRepository.deleteActivity(id);
    }


}
