package com.tse.archintiers.photosharing.model.mapper;

import com.tse.archintiers.photosharing.model.dto.UserPhoto;
import com.tse.archintiers.photosharing.model.entity.UserPhotoEntity;

public class UserPhotoMapper {

    public static UserPhoto userPhotoEntityToUserPhoto(UserPhotoEntity userPhotoEntity) {
        UserPhoto userPhoto = new UserPhoto();
        if(userPhotoEntity.getUser() != null) {
            userPhoto.setUser(UserMapper.userEntityToUser(userPhotoEntity.getUser()));
        }
        if(userPhotoEntity.getPhoto() != null) {
            userPhoto.setPhoto(PhotoMapper.photoEntityToPhoto(userPhotoEntity.getPhoto()));
        }
        return userPhoto;
    }

    public static UserPhotoEntity userPhotoToUserPhotoEntity(UserPhoto userPhoto) {
        UserPhotoEntity userPhotoEntity = new UserPhotoEntity();
        if(userPhoto.getUser() != null) {
            userPhotoEntity.setUser(UserMapper.userToUserEntity(userPhoto.getUser()));
        }
        if(userPhoto.getPhoto() != null) {
            userPhotoEntity.setPhoto(PhotoMapper.photoToPhotoEntity(userPhoto.getPhoto()));
        }
        return userPhotoEntity;
    }
}
