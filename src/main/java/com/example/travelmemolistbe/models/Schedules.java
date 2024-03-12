package com.example.travelmemolistbe.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schedulesId;
    private String title;
    private String description;
    private String address;
    private Date startDay;
    private Date endDay;

    private Boolean status;
    private Boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "schedule")
    private List<DayActivities> dayActivities;

}
