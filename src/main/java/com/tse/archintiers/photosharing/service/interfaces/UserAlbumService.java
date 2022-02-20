package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.UserAlbum;

public interface UserAlbumService {
    UserAlbum createUserAlbum(Long albumId, String userEmail);

    void deleteUserAlbum(Long albumId, String userEmail);
}
