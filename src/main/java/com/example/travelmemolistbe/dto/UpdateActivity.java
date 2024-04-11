package com.example.travelmemolistbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateActivity {
    String activityName;
    String description;
    String endTime;
    String startTime;
}
