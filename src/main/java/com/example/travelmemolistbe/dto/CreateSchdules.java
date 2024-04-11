package com.example.travelmemolistbe.dto;

import com.example.travelmemolistbe.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@AllArgsConstructor
public class CreateSchdules {
    private Integer schedulesId;
    private String title;
    private String description;
    private String address;
    private Date startDay;
    private Date endDay;
    private Long userId;
}
