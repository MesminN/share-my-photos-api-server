package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.dto.payload.request.LoginRequest;
import com.tse.archintiers.photosharing.model.dto.payload.request.SignupRequest;
import com.tse.archintiers.photosharing.model.dto.payload.response.JwtResponse;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthController {

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws Exception;
}
