package com.example.travelmemolistbe.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ImagesOfActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImage;
    private String urlImages;
    @ManyToOne(fetch = FetchType.LAZY)
    private Activities activities;
}
