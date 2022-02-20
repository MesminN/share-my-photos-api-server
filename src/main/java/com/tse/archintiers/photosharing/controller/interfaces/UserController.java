package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.User;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
public interface UserController {

    @GetMapping
    ResponseEntity<Boolean> isUserPresent(@RequestParam(value = "email") String email);

    @GetMapping(value="/{id}")
    ResponseEntity<User> getUser(@PathVariable(value = "id") Long id);

    @GetMapping(value="/")
    ResponseEntity<List<User>> listUsers();

    @PostMapping(value="/")
    ResponseEntity<User> createNewUser(@RequestBody User user);
}
