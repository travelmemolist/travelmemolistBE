package com.example.travelmemolistbe.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ImagesOfActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String urlImages;
    private Boolean isDelete;
    @ManyToOne(fetch = FetchType.LAZY)
    private Activities activities;
}
