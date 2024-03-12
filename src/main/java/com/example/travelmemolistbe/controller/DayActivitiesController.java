package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.UpdateNameDayActivities;
import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.service.impl.DayOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dayofactivies")
public class DayActivitiesController {
    @Autowired
    private DayOfActivitiesService dayOfActivitiesService;

    @PutMapping("/update")
    private ResponseEntity<?> updateNameOfDayActivities(@RequestBody UpdateNameDayActivities request) {
        String activitiesId = request.getActivitiesId();
        String activitiesName = request.getNameDayActivities();
        dayOfActivitiesService.updateName(activitiesName, activitiesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
