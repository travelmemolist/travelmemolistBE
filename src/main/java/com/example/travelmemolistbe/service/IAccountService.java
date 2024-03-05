package com.example.travelmemolistbe.service;

import com.example.travelmemolistbe.models.User;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    User findAccountByUsername(String username);
    void createAccount(String username,String password);
}
