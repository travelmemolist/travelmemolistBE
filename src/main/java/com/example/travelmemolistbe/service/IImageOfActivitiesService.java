package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.models.Activities;
import com.example.travelmemolistbe.models.ImagesOfActivities;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IImageOfActivitiesService {
    void createImage(ImagesOfActivities iImageOfActivities);
    List<ImagesOfActivities> getAllImage(String activityID);
}
