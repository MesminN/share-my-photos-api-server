package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.UserPhoto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/share-photo")
public interface UserPhotoController {

    @PostMapping(value = "/{albumId}/{userEmail}")
    ResponseEntity<UserPhoto> createUserPhoto(@PathVariable(value = "photoId") Long photoId,
                                              @PathVariable(value = "userEmail") String userEmail);

    @DeleteMapping(value = "/{albumId}/{userEmail}")
    ResponseEntity<?> deleteUserPhoto(@PathVariable(value = "photoId") Long photoId,
                                      @PathVariable(value = "userEmail") String userEmail);
}
