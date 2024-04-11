package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.AccountInfoDTO;
import com.example.travelmemolistbe.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    AccountService accountService;

    @GetMapping("/get-user-by-username/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable("username") String username) {
        AccountInfoDTO accountInfo = accountService.getAccountByUsername(username);
        if (accountInfo != null) {
            return new ResponseEntity<>(accountInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user not exits", HttpStatus.CONFLICT);
        }
    }
}
