package com.growthmate.authentication.controller;
import org.springframework.web.bind.annotation.*;

import com.growthmate.authentication.dto.AuthResponse;
import com.growthmate.authentication.dto.LoginRequest;
import com.growthmate.authentication.dto.SignupRequest;
import com.growthmate.authentication.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public AuthResponse signup(@Valid @RequestBody SignupRequest request) {
        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
}