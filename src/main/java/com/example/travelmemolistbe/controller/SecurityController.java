package com.example.travelmemolistbe.controller;

import com.example.travelmemolistbe.dto.AccountInfoDTO;
import com.example.travelmemolistbe.dto.LoginRequest;
import com.example.travelmemolistbe.dto.LoginResponse;
import com.example.travelmemolistbe.dto.ResponseStatusDTO;
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
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
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
    public ResponseEntity<ResponseStatusDTO> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    ));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
            String username = tokenProvider.getUserNameFromJWT(jwt);
            AccountInfoDTO accountInfoDTO = userRepository.getUserByUsername(username);
            LoginResponse loginResponse = new LoginResponse(jwt, accountInfoDTO);
            return new ResponseEntity<>(new ResponseStatusDTO<>(200, "Đăng nhập thành công", loginResponse), HttpStatus.OK);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>(new ResponseStatusDTO<>(401, "Tài khoản hoặc mật khẩu không đúng!", null), HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseStatusDTO> createAccount(@RequestBody User user) {
        User user1 = userRepository.findUserByUsername(user.getUsername());
        if (user.getUsername() == null) {
            return new ResponseEntity<>(new ResponseStatusDTO(409, "Username null", ""), HttpStatus.OK);
        }
        if (user.getPassword() == null) {
            return new ResponseEntity<>(new ResponseStatusDTO(409, "Password null", ""), HttpStatus.OK);
        }
        if (user1 != null) {
            return new ResponseEntity<>(new ResponseStatusDTO(409, "Tên đăng nhập tồn tại", ""), HttpStatus.OK);
        }
        accountService.createUser(user);
        return new ResponseEntity<>(new ResponseStatusDTO(200, "Tạo tài khoảng thành công", ""), HttpStatus.OK);
    }


}
