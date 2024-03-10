package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.service.impl.DayOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/dayofactivies")
public class DayActivitiesController {
    @Autowired
    private DayOfActivitiesService dayOfActivitiesService;

    @PutMapping("/{id}")
    private ResponseEntity <?> updateNameOfDayActivities(@PathVariable("id")String idDayActivities, @RequestBody DayActivities dayActivities){
        System.out.println(idDayActivities);
        System.out.println(dayActivities);
            dayOfActivitiesService.updateName(idDayActivities,dayActivities.getNameOfDayActivities());
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
