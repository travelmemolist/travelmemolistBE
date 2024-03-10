package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.ImagesOfActivities;
import com.example.travelmemolistbe.repository.IImageOfActivitiesRepository;
import com.example.travelmemolistbe.service.IImageOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageOfActivitiesService implements IImageOfActivitiesService {
    @Autowired
    private IImageOfActivitiesRepository iImageOfActivitiesRepository;
    @Override
    public void createImage(ImagesOfActivities iImageOfActivities) {
        iImageOfActivitiesRepository.save(iImageOfActivities);
    }

    @Override
    public List<ImagesOfActivities> getAllImage(String activityID) {
        return iImageOfActivitiesRepository.findAllByActivityId(activityID);
    }

    @Override
    public List<ImagesOfActivities> getAllImageBySchedules(String schedulesId) {
        return iImageOfActivitiesRepository.findAllBySchedulesID(schedulesId);
    }
}
