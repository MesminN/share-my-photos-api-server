package com.tse.archintiers.photosharing.service.implementation;

import com.tse.archintiers.photosharing.model.dto.Album;
import com.tse.archintiers.photosharing.model.dto.UserAlbum;
import com.tse.archintiers.photosharing.model.entity.AlbumEntity;
import com.tse.archintiers.photosharing.model.entity.PKs.UserAlbumPK;
import com.tse.archintiers.photosharing.model.entity.UserAlbumEntity;
import com.tse.archintiers.photosharing.model.entity.UserEntity;
import com.tse.archintiers.photosharing.model.mapper.UserAlbumMapper;
import com.tse.archintiers.photosharing.repository.AlbumRepository;
import com.tse.archintiers.photosharing.repository.PhotoRepository;
import com.tse.archintiers.photosharing.repository.UserAlbumRepository;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.service.interfaces.PhotoService;
import com.tse.archintiers.photosharing.service.interfaces.UserAlbumService;
import com.tse.archintiers.photosharing.service.interfaces.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAlbumServiceImpl implements UserAlbumService {
    @Autowired
    UserAlbumRepository userAlbumRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UserPhotoService userPhotoService;

    @Override
    public UserAlbum createUserAlbum(Long albumId, String userEmail) {
        AlbumEntity album = albumRepository.findById(albumId).get();
        album.getPhotos().forEach(photoEntity -> {
            userPhotoService.createUserPhoto(photoEntity.getId(), userEmail);
        });
        return UserAlbumMapper.userAlbumEntityToUserAlbum(userAlbumRepository.save(new UserAlbumEntity(userRepository.findByEmail(userEmail).get(), album)));
    }

    @Override
    public void deleteUserAlbum(Long albumId, String userEmail) {
        AlbumEntity album = albumRepository.findById(albumId).get();
        album.getPhotos().forEach(photoEntity -> {
            userPhotoService.deleteUserPhoto(photoEntity.getId(), userEmail);
        });
        userAlbumRepository.delete(userAlbumRepository.findById(new UserAlbumPK(userRepository.findByEmail(userEmail).get().getId(), albumId)).get());
    }
}
