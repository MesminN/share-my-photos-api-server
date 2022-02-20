package com.tse.archintiers.photosharing.controller.implementation;

import com.tse.archintiers.photosharing.controller.interfaces.AlbumController;
import com.tse.archintiers.photosharing.model.dto.Album;
import com.tse.archintiers.photosharing.security.dto.UserDetailsAuth;
import com.tse.archintiers.photosharing.service.interfaces.AlbumService;
import com.tse.archintiers.photosharing.service.interfaces.UserAlbumService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlbumControllerImpl implements AlbumController {

    @Autowired
    AlbumService albumService;

    @Autowired
    UserAlbumService userAlbumService;

    @Override
    public ResponseEntity<Album> getAlbum(Long id, Authentication authentication) {
        return ResponseEntity.ok().body(albumService.getAlbumFromUser(id, ((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<List<Album>> listAlbums(Authentication authentication) {
        return ResponseEntity.ok().body(albumService.listAlbumsFromUser(((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<Album> updateAlbum(Long id, Album album, Authentication authentication) {
        return ResponseEntity.ok().body(albumService.updateAlbumForUser(id, album, ((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<Album> createNewAlbum(Album album, Authentication authentication) {
        return ResponseEntity.ok().body(albumService.createNewAlbumForUser(album, ((UserDetailsAuth)authentication.getPrincipal()).getId()));
    }

    @Override
    public ResponseEntity<Album> deleteAlbum(Long id, Authentication authentication) {
        userAlbumService.deleteUserAlbum(id, ((UserDetailsAuth)authentication.getPrincipal()).getEmail());
        return ResponseEntity.ok().build();
    }
}
