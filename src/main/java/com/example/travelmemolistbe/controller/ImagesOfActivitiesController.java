package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.CreateImage;
import com.example.travelmemolistbe.models.Activities;
import com.example.travelmemolistbe.models.ImagesOfActivities;
import com.example.travelmemolistbe.service.impl.ImageOfActivitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/images")
public class ImagesOfActivitiesController {
    @Autowired
    private ImageOfActivitiesService imageOfActivitiesService;
    @GetMapping("{id}")
    public ResponseEntity<List<ImagesOfActivities>> getAllListImages(String id){
        List<ImagesOfActivities> imagesOfActivities = imageOfActivitiesService.getAllImage(id);
        return new ResponseEntity<>(imagesOfActivities,HttpStatus.OK);
    }
    @PostMapping("create_images")
    public ResponseEntity<?>saveImages(@RequestBody CreateImage imagesOfActivities){
        ImagesOfActivities imagesOfActivitiesDTO = new ImagesOfActivities();
        imagesOfActivitiesDTO.setIsDeleted(false);
        imagesOfActivitiesDTO.setUrlImages(imagesOfActivities.getUrlImages());
        imagesOfActivitiesDTO.setIdImage(imagesOfActivities.getIdImage());
        Activities activitiesDTO = new Activities();
        activitiesDTO.setActivityId(imagesOfActivities.getActivities());
        imagesOfActivitiesDTO.setActivities(activitiesDTO);
        imageOfActivitiesService.createImage(imagesOfActivitiesDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
