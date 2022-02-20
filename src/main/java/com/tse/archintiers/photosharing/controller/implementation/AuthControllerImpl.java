package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.AuthController;
import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.dto.payload.request.LoginRequest;
import com.tse.archintiers.photosharing.model.dto.payload.request.SignupRequest;
import com.tse.archintiers.photosharing.model.dto.payload.response.JwtResponse;
import com.tse.archintiers.photosharing.model.dto.payload.response.MessageResponse;
import com.tse.archintiers.photosharing.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {
    @Autowired
    AuthService authService;

    public ResponseEntity<JwtResponse> authenticateUser(LoginRequest loginRequest) {
        return ResponseEntity.ok().body(authService.authenticateUser(loginRequest));
    }

    public ResponseEntity<?> registerUser(SignupRequest signUpRequest) {
        JwtResponse jwtResponse= null;
        try {
            jwtResponse = authService.registerUser(signUpRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse(e.getMessage()));
        }
        return ResponseEntity.ok().body(jwtResponse);
    }
}
