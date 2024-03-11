package com.example.travelmemolistbe.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountInfoDTO {
    private Long userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private int age;

}
