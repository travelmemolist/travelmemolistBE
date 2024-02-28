package com.example.travelmemolistbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
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
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    private Boolean isDeleted;
}
