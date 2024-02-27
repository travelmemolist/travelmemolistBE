package com.example.travelmemolistbe.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Schedules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schedulesId;
    private String title;
    private String description;
    private String address;
    private Date startDay;
    private Date endDay;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
