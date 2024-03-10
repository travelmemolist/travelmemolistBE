package com.example.travelmemolistbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateImage {
    private Long idImage;
    private String urlImages;
    private Long activities;
}
