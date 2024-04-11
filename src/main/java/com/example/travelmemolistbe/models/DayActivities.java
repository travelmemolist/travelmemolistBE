package com.example.travelmemolistbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

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
    @JoinColumn(name = "schedules_id",referencedColumnName = "schedulesId")
    @JsonIgnore
    private Schedules schedule;

    @OneToMany(mappedBy = "dayActivities")
    private List<Activities> activities;
}
