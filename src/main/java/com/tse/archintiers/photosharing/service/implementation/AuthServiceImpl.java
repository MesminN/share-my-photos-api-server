package com.tse.archintiers.photosharing.service.implementation;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.dto.payload.JwtToken;
import com.tse.archintiers.photosharing.model.dto.payload.request.LoginRequest;
import com.tse.archintiers.photosharing.model.dto.payload.request.SignupRequest;
import com.tse.archintiers.photosharing.model.dto.payload.response.JwtResponse;
import com.tse.archintiers.photosharing.model.entity.UserEntity;
import com.tse.archintiers.photosharing.model.mapper.UserMapper;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.security.jwt.JwtUtils;
import com.tse.archintiers.photosharing.security.dto.UserDetailsAuth;
import com.tse.archintiers.photosharing.service.interfaces.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public JwtResponse authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtToken jwtToken = jwtUtils.generateJwtToken(authentication);

        UserDetailsAuth userDetails = (UserDetailsAuth) authentication.getPrincipal();
        User user = new User();
        if(userRepository.findById(userDetails.getId()).isPresent()) {
            UserEntity userEntity = userRepository.findById(userDetails.getId()).get();
            user = UserMapper.userEntityToUser(userEntity);
        }
        return new JwtResponse(jwtToken,user);
    }

    @Override
    public JwtResponse registerUser(SignupRequest signUpRequest) throws Exception {
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new Exception("Email is already in use!");
        }

        // Create new user's account
        User user = new User(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        return new JwtResponse(null, UserMapper.userEntityToUser(userRepository.save(UserMapper.userToUserEntity(user))));
    }
}
