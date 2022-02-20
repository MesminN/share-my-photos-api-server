package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.dto.payload.request.LoginRequest;
import com.tse.archintiers.photosharing.model.dto.payload.request.SignupRequest;
import com.tse.archintiers.photosharing.model.dto.payload.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticateUser(LoginRequest loginRequest);
    JwtResponse registerUser(SignupRequest signUpRequest) throws Exception;
}
