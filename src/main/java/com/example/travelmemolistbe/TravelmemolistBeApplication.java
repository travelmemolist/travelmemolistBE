package com.example.travelmemolistbe;


import com.example.travelmemolistbe.models.User;
import com.example.travelmemolistbe.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TravelmemolistBeApplication {


    public static void main(String[] args) {
        SpringApplication.run(TravelmemolistBeApplication.class, args);
    }


}
