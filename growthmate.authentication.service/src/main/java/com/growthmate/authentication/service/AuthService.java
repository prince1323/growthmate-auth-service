package com.growthmate.authentication.service;

import com.growthmate.authentication.dto.AuthResponse;
import com.growthmate.authentication.dto.LoginRequest;
import com.growthmate.authentication.dto.SignupRequest;

public interface AuthService {

    AuthResponse signup(SignupRequest request);
    AuthResponse login(LoginRequest request);

}