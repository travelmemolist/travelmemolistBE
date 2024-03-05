package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.models.User;
import com.example.travelmemolistbe.repository.IUserRepository;
import com.example.travelmemolistbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public User findAccountByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void createAccount(String username, String password) {

    }

}
