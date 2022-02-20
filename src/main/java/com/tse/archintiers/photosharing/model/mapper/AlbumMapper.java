package com.tse.archintiers.photosharing.model.mapper;

import com.tse.archintiers.photosharing.model.dto.Album;
import com.tse.archintiers.photosharing.model.entity.AlbumEntity;

public class AlbumMapper {

    public static AlbumEntity albumToAlbumEntity(Album album) {
        AlbumEntity returnedAlbumEntity = new AlbumEntity();
        if(album.getId() != null) {
            returnedAlbumEntity.setId(album.getId());
        }
        if(album.getName() != null) {
            returnedAlbumEntity.setName(album.getName());
        }
        if(album.getDescription() != null) {
            returnedAlbumEntity.setDescription(album.getDescription());
        }
        if(album.getBackgroundColor() != null) {
            returnedAlbumEntity.setBackgroundColor(album.getBackgroundColor());
        }
        if(album.getUser() != null) {
            returnedAlbumEntity.setUser(UserMapper.userToUserEntity(album.getUser()));
        }
        return returnedAlbumEntity;
    }

    public static Album albumEntityToAlbum(AlbumEntity albumEntity) {
        Album returnedAlbum = new Album();
        if(albumEntity.getId() != null) {
            returnedAlbum.setId(albumEntity.getId());
        }
        if(albumEntity.getName() != null) {
            returnedAlbum.setName(albumEntity.getName());
        }
        if(albumEntity.getDescription() != null) {
            returnedAlbum.setDescription(albumEntity.getDescription());
        }
        if(albumEntity.getBackgroundColor() != null) {
            returnedAlbum.setBackgroundColor(albumEntity.getBackgroundColor());
        }
        if(albumEntity.getUser() != null) {
            returnedAlbum.setUser(UserMapper.userEntityToUser(albumEntity.getUser()));
        }
        return returnedAlbum;
    }
}
