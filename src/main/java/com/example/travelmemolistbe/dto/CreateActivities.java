package com.example.travelmemolistbe.dto;

import com.example.travelmemolistbe.models.DayActivities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateActivities {
    private String activityName;
    private String description;
    private String startTime;
    private String endTime;
    private Long dayActivityId;
}
