package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.repository.IDayActiviesRepository;
import com.example.travelmemolistbe.service.IDayOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayOfActivitiesService implements IDayOfActivitiesService {
    @Autowired
    private IDayActiviesRepository iDayActiviesRepository;
    @Override
    public void updateName(String nameOfDayActivities, String idOfDayActivities) {
        iDayActiviesRepository.updateNameOfDayActivities(nameOfDayActivities, idOfDayActivities);
    }
}
