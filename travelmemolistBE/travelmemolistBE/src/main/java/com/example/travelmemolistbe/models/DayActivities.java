package com.example.travelmemolistbe.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class DayActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDayActivities;
    private String nameOfDayActivities;
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedules schedule;
}
