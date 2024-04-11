package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.repository.IDayActiviesRepository;
import com.example.travelmemolistbe.service.IDayOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayOfActivitiesService implements IDayOfActivitiesService {
    @Autowired
    private IDayActiviesRepository iDayActiviesRepository;
    @Override
    public void updateName(String nameOfDayActivities, String idOfDayActivities) {
        iDayActiviesRepository.updateNameOfDayActivities(nameOfDayActivities, idOfDayActivities);
    }

    @Override
    public List<DayActivities> listActivities(String schedulesId) {
        return iDayActiviesRepository.listActivities(schedulesId);
    }
}
