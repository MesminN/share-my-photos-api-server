package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.UserAlbum;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/share-album")
public interface UserAlbumController {

    @PostMapping(value = "/{albumId}/{userEmail}")
    ResponseEntity<UserAlbum> createUserAlbum(@PathVariable(value = "albumId") Long albumId,
                                              @PathVariable(value = "userEmail") String userEmail);

    @DeleteMapping(value = "/{albumId}/{userEmail}")
    ResponseEntity<?> deleteUserAlbum(@PathVariable(value = "albumId") Long albumId,
                                      @PathVariable(value = "userEmail") String userEmail);
}
