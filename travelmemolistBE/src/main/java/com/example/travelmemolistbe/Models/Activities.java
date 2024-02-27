package com.example.travelmemolistbe.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityId;
    private String activityName;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private DayActivities dayActivities;
}
