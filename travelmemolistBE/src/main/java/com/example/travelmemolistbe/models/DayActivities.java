package com.example.travelmemolistbe.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DayActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDayActivities;
    private String nameOfDayActivities;
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedules schedule;
}
