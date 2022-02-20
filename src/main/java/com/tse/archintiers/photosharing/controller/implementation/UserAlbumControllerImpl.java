package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.UserAlbumController;
import com.tse.archintiers.photosharing.model.dto.UserAlbum;
import com.tse.archintiers.photosharing.service.interfaces.UserAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAlbumControllerImpl implements UserAlbumController {
    @Autowired
    UserAlbumService userAlbumService;

    @Override
    public ResponseEntity<UserAlbum> createUserAlbum(Long albumId, String userEmail) {
        return ResponseEntity.ok().body(userAlbumService.createUserAlbum(albumId, userEmail));
    }

    @Override
    public ResponseEntity<?> deleteUserAlbum(Long albumId, String userEmail) {
        userAlbumService.deleteUserAlbum(albumId, userEmail);
        return ResponseEntity.ok().build();
    }
}
