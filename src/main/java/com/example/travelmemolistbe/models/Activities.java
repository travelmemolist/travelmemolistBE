package com.example.travelmemolistbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long activityId;
    private String activityName;
    private String description;
    private Boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    private DayActivities dayActivities;
}
