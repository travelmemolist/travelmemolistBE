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
    private String nameOfDayActivities;
    private Date currentDay;
    private String day;
    private Boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    private Schedules schedule;
}
