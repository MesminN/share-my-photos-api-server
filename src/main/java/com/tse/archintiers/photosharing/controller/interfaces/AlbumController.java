package com.tse.archintiers.photosharing.controller.interfaces;

import com.tse.archintiers.photosharing.model.dto.Album;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/album")
public interface AlbumController {

    @GetMapping(value="/{id}")
    ResponseEntity<Album> getAlbum(@PathVariable(value = "id") Long id, Authentication authentication);

    @GetMapping(value="/")
    ResponseEntity<List<Album>> listAlbums(Authentication authentication);

    @PutMapping(value="/{id}")
    ResponseEntity<Album> updateAlbum(@PathVariable(value = "id") Long id, @RequestBody Album album, Authentication authentication);

    @PostMapping(value="/")
    ResponseEntity<Album> createNewAlbum(@RequestBody Album albumEntity, Authentication authentication);


    @DeleteMapping(value="/{id}")
    ResponseEntity<Album> deleteAlbum(@PathVariable(value = "id") Long id, Authentication authentication);
}