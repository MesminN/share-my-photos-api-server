package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.UserPhoto;

public interface UserPhotoService {
    UserPhoto createUserPhoto(Long photoId, String userEmail);

    void deleteUserPhoto(Long photoId, String userEmail);
}
