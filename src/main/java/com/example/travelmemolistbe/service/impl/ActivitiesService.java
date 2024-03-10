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
        iActivitiesRepository.save(activities);
    }

    @Override
    public List<Activities> findAllActivitiesByDayActivities(int idDayActivities) {
        return iActivitiesRepository.findAllActivitiesByDayActivities(idDayActivities);
    }


}
