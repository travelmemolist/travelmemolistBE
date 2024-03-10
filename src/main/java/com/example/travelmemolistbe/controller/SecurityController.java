package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.LoginRequest;
import com.example.travelmemolistbe.dto.LoginResponse;
import com.example.travelmemolistbe.jwt.JwtTokenProvider;
import com.example.travelmemolistbe.models.User;
import com.example.travelmemolistbe.repository.IUserRepository;
import com.example.travelmemolistbe.service.impl.AccountService;
import com.example.travelmemolistbe.service.impl.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class SecurityController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    AccountService accountService;
    @Autowired
    IUserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        String username = tokenProvider.getUserNameFromJWT(jwt);
        return ResponseEntity.ok( new LoginResponse(jwt,username));
    }
    @GetMapping("/test")
    public ResponseEntity<String> test(){
        String test = "hello";
        return ResponseEntity.ok(test);
    }
    @PostMapping("/user/create")
    public ResponseEntity<?> createAccount(@RequestBody User user){
        User  user1 = userRepository.findUserByUsername(user.getUsername());
        if (user1!=null){
            return new ResponseEntity<>("User exits", HttpStatus.CONFLICT);
        }
        accountService.createUser(user);
        return new ResponseEntity<>("Create successfully",HttpStatus.OK);
    }
}
