package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.models.Schedules;
import com.example.travelmemolistbe.service.impl.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/schedules")
public class SchedulesController {
    @Autowired
    private SchedulesService iSchedulesService;

    @GetMapping("")
    public ResponseEntity<Page<Schedules>> findAllSchedules(@RequestParam(value = "title") String title,
                                                            @RequestParam(value = "userid") String userid,
                                                            @RequestParam(defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Schedules> pageSchedules = iSchedulesService.findAllSchedulesByUserId(pageable, userid, title);
        if (pageSchedules.getContent() == null) {
            ResponseEntity<Schedules> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(pageSchedules);
    }


}
