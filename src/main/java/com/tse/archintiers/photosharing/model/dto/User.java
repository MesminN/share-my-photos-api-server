package com.tse.archintiers.photosharing.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    public User() {
    }

    public User(String firstname, String lastname, String email, String password) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }
}