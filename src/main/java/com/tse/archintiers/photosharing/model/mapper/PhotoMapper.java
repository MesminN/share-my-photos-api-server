package com.tse.archintiers.photosharing.model.mapper;


import com.tse.archintiers.photosharing.model.dto.Photo;
import com.tse.archintiers.photosharing.model.entity.PhotoEntity;

public class PhotoMapper {

    public static PhotoEntity photoToPhotoEntity(Photo photo) {
        PhotoEntity photoEntity = new PhotoEntity();
        if(photo.getId() != null) {
            photoEntity.setId(photo.getId());
        }
        if(photo.getName() != null) {
            photoEntity.setName(photo.getName());
        }
        if(photo.getDescription() != null) {
            photoEntity.setDescription(photo.getDescription());
        }
        if(photo.getType() != null) {
            photoEntity.setType(photo.getType());
        }
        if(photo.getAlbum() != null) {
            photoEntity.setAlbum(AlbumMapper.albumToAlbumEntity(photo.getAlbum()));
        }
        if(photo.getUser() != null) {
            photoEntity.setUser(UserMapper.userToUserEntity(photo.getUser()));
        }
        return photoEntity;
    }

    public static Photo photoEntityToPhoto(PhotoEntity photoEntity) {
        Photo photo = new Photo();
        if(photoEntity.getId() != null) {
            photo.setId(photoEntity.getId());
        }
        if(photoEntity.getName() != null) {
            photo.setName(photoEntity.getName());
        }
        if(photoEntity.getDescription() != null) {
            photo.setDescription(photoEntity.getDescription());
        }
        if(photoEntity.getType() != null) {
            photo.setType(photoEntity.getType());
        }
        if(photoEntity.getAlbum() != null) {
            photo.setAlbum(AlbumMapper.albumEntityToAlbum(photoEntity.getAlbum()));
        }
        if(photoEntity.getUser() != null) {
            photo.setUser(UserMapper.userEntityToUser(photoEntity.getUser()));
        }
        return photo;
    }
}
