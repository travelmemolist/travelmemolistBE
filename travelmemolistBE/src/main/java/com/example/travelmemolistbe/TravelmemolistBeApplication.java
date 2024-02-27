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

    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

//    @Override
//    public void run(String... args) throws Exception {
//        User user = new User();
//        user.setUserId(1L);
//        user.setUsername("phat1");
//        user.setPassword(passwordEncoder.encode("123"));
//        user.setAge(20);
//        user.setEmail("vo@gmail.com");
//        user.setFirstName("vo");
//        user.setLastName("phat");
//        userRepository.save(user);
//        System.out.println(user);
//    }
}
