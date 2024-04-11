package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.CreateActivities;
import com.example.travelmemolistbe.dto.UpdateActivity;
import com.example.travelmemolistbe.models.Activities;
import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.service.IActivitiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/activities")
public class ActivitiesController {
    @Autowired
    private IActivitiesService  iActivitiesService;

    @PostMapping("create-activity")
    public ResponseEntity<?> createActivity(@RequestBody CreateActivities activityDTO){
        System.out.println(activityDTO);
        Activities activity = new Activities();
        activity.setActivityName(activityDTO.getActivityName());
        activity.setDescription(activityDTO.getDescription());
        activity.setStartTime(activityDTO.getStartTime());
        activity.setEndTime(activityDTO.getEndTime());
        activity.setIsDeleted(false);
        DayActivities dayActivities = new DayActivities();
        dayActivities.setIdDayActivities(activityDTO.getDayActivityId());
        activity.setDayActivities(dayActivities);
        iActivitiesService.saveActivities(activity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<Activities>> getAllActivitiesByDayActivities(@PathVariable("id") int idDayActivities) {
        List<Activities> listActivities = iActivitiesService.findAllActivitiesByDayActivities(idDayActivities);
        return new ResponseEntity<>(listActivities, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Activities> getActivityById(@PathVariable("id") Long id){
        Activities activities = iActivitiesService.findActivityById(id);
        return new ResponseEntity<>(activities,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateActivity(@PathVariable("id")String id,@RequestBody UpdateActivity updateActivity){
        iActivitiesService.updateActivities(updateActivity.getActivityName(),updateActivity.getDescription(),updateActivity.getEndTime(), updateActivity.getStartTime(),id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity< ? > deleteActivity(@PathVariable ("id") String id) {
        iActivitiesService.deleteActivities(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
