package com.example.travelmemolistbe.service;

import org.springframework.stereotype.Service;

@Service
public interface IDayOfActivitiesService {
    void updateName(String nameOfDayActivities,String idOfDayActivities);
}
