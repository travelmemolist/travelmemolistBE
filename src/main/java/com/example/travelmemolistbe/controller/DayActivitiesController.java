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

    @PutMapping("/{id}")
    private ResponseEntity <?> updateNameOfDayActivities(@PathVariable("id")String idDayActivities, @RequestBody UpdateNameDayActivities dayActivities){
        System.out.println(idDayActivities);
        System.out.println(dayActivities);
        DayActivities dayActivitiesDTO = new DayActivities();
              dayActivitiesDTO.setNameOfDayActivities(dayActivities.getNameDayActivities());
            dayOfActivitiesService.updateName(idDayActivities,dayActivitiesDTO.getNameOfDayActivities());
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
