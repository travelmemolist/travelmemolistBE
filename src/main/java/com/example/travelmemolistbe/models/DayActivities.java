package com.example.travelmemolistbe.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class DayActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDayActivities;
    private String day;
    private Date currentDay;
    private String nameOfDayActivities;
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedules schedule;
}
