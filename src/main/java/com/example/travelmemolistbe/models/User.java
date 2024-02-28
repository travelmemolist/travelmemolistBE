package com.example.travelmemolistbe.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    private int age;

    public User() {
    }

    public User(Long userId, String username, String password, String email, String firstName, String lastName, int age) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

}
