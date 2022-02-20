package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.PhotoController;
import com.tse.archintiers.photosharing.model.dto.Photo;
import com.tse.archintiers.photosharing.security.dto.UserDetailsAuth;
import com.tse.archintiers.photosharing.service.interfaces.PhotoService;
import com.tse.archintiers.photosharing.service.interfaces.UserPhotoService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoControllerImpl implements PhotoController {

    @Autowired
    PhotoService photoService;

    @Override
    public ResponseEntity<Photo> getPhoto(Long id, Authentication authentication) {
        return ResponseEntity.ok().body(photoService.getPhotoFromUser(id, ((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<List<Photo>> listPhotos(Authentication authentication) {
        return ResponseEntity.ok().body(photoService.listPhotosFromUser(((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<Photo> uploadImage(MultipartFile file, String imageDesc, Long albumId, String type, Authentication authentication) throws Exception {
        Photo returnedPhoto = null;
        try {
            returnedPhoto = photoService.uploadImageForUser(file, imageDesc, albumId, type, ((UserDetailsAuth)authentication.getPrincipal()).getId());
        } catch (IOException e) {
            throw new Exception("Couldn't upload file");
        }
        return ResponseEntity.ok().body(returnedPhoto);
    }
}
