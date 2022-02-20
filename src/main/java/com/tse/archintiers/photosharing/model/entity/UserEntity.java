package com.tse.archintiers.photosharing.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "email", nullable = false)
    protected String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<AlbumEntity> albums = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<PhotoEntity> photos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<UserPhotoEntity> userPhotos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<UserAlbumEntity> userAlbums = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(String firstname, String lastname, String email, String password) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = email;
        this.password = password;
    }
}