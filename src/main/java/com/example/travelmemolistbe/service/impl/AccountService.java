package com.example.travelmemolistbe.service.impl;

import com.example.travelmemolistbe.dto.AccountInfoDTO;
import com.example.travelmemolistbe.models.User;
import com.example.travelmemolistbe.repository.IUserRepository;
import com.example.travelmemolistbe.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    IUserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User findAccountByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public void createAccount(String username, String password) {
    }

    @Override
    public void createUser(User user) {
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public AccountInfoDTO getAccountByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }


}
