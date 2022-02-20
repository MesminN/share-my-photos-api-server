package com.tse.archintiers.photosharing.model.mapper;

import com.tse.archintiers.photosharing.model.dto.UserAlbum;
import com.tse.archintiers.photosharing.model.entity.UserAlbumEntity;

public class UserAlbumMapper {

    public static UserAlbum userAlbumEntityToUserAlbum(UserAlbumEntity userAlbumEntity) {
        UserAlbum userAlbum = new UserAlbum();
        if(userAlbumEntity.getUser() != null) {
            userAlbum.setUser(UserMapper.userEntityToUser(userAlbumEntity.getUser()));
        }
        if(userAlbumEntity.getAlbum() != null) {
            userAlbum.setAlbum(AlbumMapper.albumEntityToAlbum(userAlbumEntity.getAlbum()));
        }
        return userAlbum;
    }

    public static UserAlbumEntity userAlbumToUserAlbumEntity(UserAlbum userAlbum) {
        UserAlbumEntity userAlbumEntity = new UserAlbumEntity();
        if(userAlbum.getUser() != null) {
            userAlbumEntity.setUser(UserMapper.userToUserEntity(userAlbum.getUser()));
        }
        if(userAlbum.getAlbum() != null) {
            userAlbumEntity.setAlbum(AlbumMapper.albumToAlbumEntity(userAlbum.getAlbum()));
        }
        return userAlbumEntity;
    }
}
