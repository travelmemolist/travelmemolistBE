package com.example.travelmemolistbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseStatusDTO<T> {
    private int status;
    private String message;
    private T data;
}
