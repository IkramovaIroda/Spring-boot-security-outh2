package com.example.temirovasadbekv2springbootmodul2.controller;

import com.example.temirovasadbekv2springbootmodul2.dto.LoginDTO;
import com.example.temirovasadbekv2springbootmodul2.security.JwtProvider;
import com.example.temirovasadbekv2springbootmodul2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String token = jwtProvider.generateToken(loginDTO.getUserName());
        return ResponseEntity.ok().body(token);
    }


}
