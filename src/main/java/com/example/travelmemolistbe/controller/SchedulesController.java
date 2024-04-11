package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.CreateSchdules;
import com.example.travelmemolistbe.models.DayActivities;
import com.example.travelmemolistbe.models.Schedules;
import com.example.travelmemolistbe.models.User;
import com.example.travelmemolistbe.service.IDayOfActivitiesService;
import com.example.travelmemolistbe.service.impl.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("api/schedules")
public class SchedulesController {

    @Autowired
    private IDayOfActivitiesService iDayOfActivitiesService;
    @Autowired
    private SchedulesService schedulesService;

    @GetMapping("")
    public ResponseEntity<Page<Schedules>> findAllSchedules(@RequestParam(value = "title",defaultValue = "") String title,
                                                            @RequestParam(value = "userid") Long userid,
                                                            @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page , 5);
        Page<Schedules> pageSchedules = schedulesService.findAllSchedulesByUserId(pageable, userid, title);
        if (pageSchedules.getContent() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(pageSchedules);
    }
    @PostMapping("/create-schedules")
    public ResponseEntity<?>createSchedules(@RequestBody CreateSchdules request){
        Schedules s = new Schedules();
        s.setTitle(request.getTitle());
        s.setDescription(request.getDescription());
        s.setAddress(request.getAddress());
        s.setStartDay(request.getStartDay());
        s.setEndDay(request.getEndDay());
        s.setIsDeleted(false);
        s.setStatus(false);
        User user = new User();
        user.setUserId(request.getUserId());
        s.setUser(user);
       Schedules scheduleID = schedulesService.createSchedules(s);
        return new ResponseEntity<>(scheduleID,HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<DayActivities>> getListDayActivitiesByScheduleId(@PathVariable("id") String id) {
        List<DayActivities> dayActivities = iDayOfActivitiesService.listActivities(id);
        return new ResponseEntity<>(dayActivities,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateStatus(@PathVariable("id") String id){
        schedulesService.updateStatus(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-day-activities/{scheduleId}")
    public List<DayActivities> getDayActivitiesByScheduleId(@PathVariable Long scheduleId) {
        return schedulesService.getDayActivitiesByScheduleId(scheduleId);
    }
}
