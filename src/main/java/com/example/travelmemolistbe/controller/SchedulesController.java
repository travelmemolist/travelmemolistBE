package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.models.Schedules;
import com.example.travelmemolistbe.service.ISchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/schedules")
public class SchedulesController {
    @Autowired
    private ISchedulesService ischedulesService;

    @GetMapping("")
    public ResponseEntity<Page<Schedules>> findAllSchedules(@RequestParam(value = "title",defaultValue = "") String title,
                                                            @RequestParam(value = "userid") String userid,
                                                            @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Schedules> pageSchedules = ischedulesService.findAllSchedulesByUserId(pageable, userid, title);
        if (pageSchedules.getContent() == null) {
            ResponseEntity<Schedules> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(pageSchedules);
    }
    @PostMapping("/createsschedules")
    public ResponseEntity<?>createSchedules(@RequestBody Schedules schedules){
        System.out.println(schedules);
        ischedulesService.createSchedules(Math.toIntExact(schedules.getSchedulesId()),schedules.getTitle(),schedules.getDescription(),schedules.getAddress(),schedules.getStartDay(),schedules.getEndDay(),schedules.getUser().getUserId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
