package com.tse.archintiers.photosharing.service.implementation;

import static com.tse.archintiers.photosharing.utils.PhotoSharingConstants.IMAGES_BASE_PATH;

import com.tse.archintiers.photosharing.model.dto.Album;
import com.tse.archintiers.photosharing.model.dto.Photo;
import com.tse.archintiers.photosharing.model.entity.AlbumEntity;
import com.tse.archintiers.photosharing.model.entity.PKs.UserPhotoPK;
import com.tse.archintiers.photosharing.model.entity.PhotoEntity;
import com.tse.archintiers.photosharing.model.mapper.AlbumMapper;
import com.tse.archintiers.photosharing.model.mapper.PhotoMapper;
import com.tse.archintiers.photosharing.model.mapper.UserMapper;
import com.tse.archintiers.photosharing.repository.AlbumRepository;
import com.tse.archintiers.photosharing.repository.PhotoRepository;
import com.tse.archintiers.photosharing.repository.UserPhotoRepository;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.service.interfaces.PhotoService;
import com.tse.archintiers.photosharing.service.interfaces.UserPhotoService;
import com.tse.archintiers.photosharing.utils.FileUtils;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    PhotoRepository photoRepository;

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPhotoService userPhotoService;

    @Autowired
    UserPhotoRepository userPhotoRepository;

    @Override
    public Photo getPhotoFromUser(Long id, Long userId) {
        Photo retrievedPhoto = null;
        PhotoEntity photoEntity = userPhotoRepository.findById(new UserPhotoPK(userId, id)).get().getPhoto();
        if(photoEntity != null) {
            retrievedPhoto = PhotoMapper.photoEntityToPhoto(photoEntity);
        }
        return updatePhotoValue(retrievedPhoto);
    }

    @Override
    public List<Photo> listPhotosFromUser(Long userId) {
        List<Photo> returnedPhotos = new ArrayList<>();
        userPhotoRepository.findAllByUserId(userId).forEach(userPhotoEntity -> {
            returnedPhotos.add(PhotoMapper.photoEntityToPhoto(userPhotoEntity.getPhoto()));
        });
        for (Photo photo : returnedPhotos) {
            updatePhotoValue(photo);
        }
        return returnedPhotos;
    }

    public Photo uploadImageForUser(MultipartFile file, String imageDesc, Long albumId, String type, Long userId) {
        Photo photo = new Photo(file.getOriginalFilename(), imageDesc);
        if(albumId != null) {
            Optional<AlbumEntity> albumEntityOptional = albumRepository.findById(albumId);
            albumEntityOptional.ifPresent(albumEntity -> photo.setAlbum(AlbumMapper.albumEntityToAlbum(albumEntity)));
        }
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        if(type != null) {
            photo.setType(type);
        } else{
            Optional<String> extensionOptional =  FileUtils.getExtensionByStringHandling(fileName);
            extensionOptional.ifPresent(photo::setType);
        }
        photo.setUser(UserMapper.userEntityToUser(userRepository.findById(userId).get()));
        Photo savedPhoto = createImage(photo);

        userPhotoService.createUserPhoto(savedPhoto.getId(), photo.getUser().getEmail());

        Path path = Paths.get(IMAGES_BASE_PATH + savedPhoto.getId()+"_"+fileName);
        try {
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return savedPhoto;
    }

    private Photo createImage(Photo photo) {
        return PhotoMapper.photoEntityToPhoto(photoRepository.save(PhotoMapper.photoToPhotoEntity(photo)));
    }

    public Photo updatePhotoValue(Photo retrievedPhoto) {
        if(retrievedPhoto != null) {
            File imageFile = Paths.get(IMAGES_BASE_PATH+ retrievedPhoto.getId()+"_"+ retrievedPhoto.getName()).toFile();
            BufferedImage image = null;
            try {
                image = ImageIO.read(new FileInputStream(imageFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            retrievedPhoto.setImageValue("data:image/"+retrievedPhoto.getType()+";base64," + FileUtils.encodeToString(image,retrievedPhoto.getType()));
        }
        return retrievedPhoto;
    }
}
