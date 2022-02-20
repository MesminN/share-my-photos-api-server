package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.UserController;
import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.service.interfaces.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<Boolean> isUserPresent(String email) {
        return ResponseEntity.ok().body(userService.isUserPresent(email));
    }

    @Override
    public ResponseEntity<User> getUser(Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @Override
    public ResponseEntity<List<User>> listUsers() {
        return ResponseEntity.ok().body(userService.listUsers());
    }

    @Override
    public ResponseEntity<User> createNewUser(User user) {
        return ResponseEntity.ok().body(userService.createNewUser(user));
    }
}
