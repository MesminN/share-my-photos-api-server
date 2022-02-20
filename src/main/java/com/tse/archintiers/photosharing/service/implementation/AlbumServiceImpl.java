package com.tse.archintiers.photosharing.service.implementation;

import com.tse.archintiers.photosharing.model.dto.Album;
import com.tse.archintiers.photosharing.model.dto.Photo;
import com.tse.archintiers.photosharing.model.entity.AlbumEntity;
import com.tse.archintiers.photosharing.model.entity.PKs.UserAlbumPK;
import com.tse.archintiers.photosharing.model.mapper.AlbumMapper;
import com.tse.archintiers.photosharing.model.mapper.PhotoMapper;
import com.tse.archintiers.photosharing.model.mapper.UserMapper;
import com.tse.archintiers.photosharing.repository.AlbumRepository;
import com.tse.archintiers.photosharing.repository.PhotoRepository;
import com.tse.archintiers.photosharing.repository.UserAlbumRepository;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.service.interfaces.AlbumService;
import com.tse.archintiers.photosharing.service.interfaces.PhotoService;
import com.tse.archintiers.photosharing.service.interfaces.UserAlbumService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhotoService photoService;

    @Autowired
    UserAlbumService userAlbumService;

    @Autowired
    UserAlbumRepository userAlbumRepository;

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public Album getAlbumFromUser(Long id, Long userId) {
        AlbumEntity albumEntity = userAlbumRepository.findById(new UserAlbumPK(userId, id)).get().getAlbum();

        Album returnedAlbum = AlbumMapper.albumEntityToAlbum(albumEntity);
        List<Photo> albumsPhoto = photoRepository.findAllByAlbum(albumEntity).stream().map(PhotoMapper::photoEntityToPhoto).collect(Collectors.toList());
        albumsPhoto.forEach(photo -> {
            photoService.updatePhotoValue(photo);
        });
        returnedAlbum.setPhotos(albumsPhoto);
        return returnedAlbum;
    }

    @Override
    public List<Album> listAlbumsFromUser(Long userId) {
        List<Album> returnedAlbums = new ArrayList<>();
        userAlbumRepository.findAllByUserId(userId).forEach(userAlbumEntity -> {
            returnedAlbums.add(AlbumMapper.albumEntityToAlbum(userAlbumEntity.getAlbum()));
        });
        return returnedAlbums;
    }

    @Override
    public Album createNewAlbumForUser(Album album, Long userId) {
        userRepository.findById(userId).ifPresent(user -> {
            album.setUser(UserMapper.userEntityToFullUser(user));
        });
        Album returnedAlbum = AlbumMapper.albumEntityToAlbum(albumRepository.save(AlbumMapper.albumToAlbumEntity(album)));
        userAlbumService.createUserAlbum(returnedAlbum.getId(), returnedAlbum.getUser().getEmail());
        return returnedAlbum;
    }

    @Override
    public Album updateAlbumForUser(Long id, Album album, Long userId) {
        AlbumEntity albumEntity = albumRepository.findById(id).get();
        if(album.getName() != null) {
            albumEntity.setName(album.getName());
        }
        if(album.getDescription() != null) {
            albumEntity.setDescription(album.getDescription());
        }
        if(album.getBackgroundColor() != null) {
            albumEntity.setBackgroundColor(album.getBackgroundColor());
        }
        return AlbumMapper.albumEntityToAlbum(albumRepository.save(albumEntity));
    }
}