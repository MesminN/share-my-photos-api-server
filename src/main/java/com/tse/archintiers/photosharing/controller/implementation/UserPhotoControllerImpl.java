package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.UserPhotoController;
import com.tse.archintiers.photosharing.model.dto.UserPhoto;
import com.tse.archintiers.photosharing.service.interfaces.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class UserPhotoControllerImpl implements UserPhotoController {
    @Autowired
    UserPhotoService userPhotoService;

    @Override
    public ResponseEntity<UserPhoto> createUserPhoto(Long photoId, String userEmail) {
        return ResponseEntity.ok().body(userPhotoService.createUserPhoto(photoId, userEmail));
    }

    @Override
    public ResponseEntity<?> deleteUserPhoto(Long photoId, String userEmail) {
        userPhotoService.deleteUserPhoto(photoId, userEmail);
        return ResponseEntity.ok().build();
    }
}
