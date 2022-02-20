package com.tse.archintiers.photosharing.service.implementation;

import com.tse.archintiers.photosharing.model.dto.UserPhoto;
import com.tse.archintiers.photosharing.model.entity.PKs.UserPhotoPK;
import com.tse.archintiers.photosharing.model.entity.UserPhotoEntity;
import com.tse.archintiers.photosharing.model.mapper.UserPhotoMapper;
import com.tse.archintiers.photosharing.repository.PhotoRepository;
import com.tse.archintiers.photosharing.repository.UserPhotoRepository;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.service.interfaces.UserPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPhotoServiceImpl implements UserPhotoService {
    @Autowired
    UserPhotoRepository userPhotoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PhotoRepository photoRepository;

    @Override
    public UserPhoto createUserPhoto(Long photoId, String userEmail) {
        return UserPhotoMapper.userPhotoEntityToUserPhoto(userPhotoRepository.save(new UserPhotoEntity(userRepository.findByEmail(userEmail).get(), photoRepository.findById(photoId).get())));
    }

    @Override
    public void deleteUserPhoto(Long photoId, String userEmail) {
        userPhotoRepository.delete(userPhotoRepository.findById(new UserPhotoPK(userRepository.findByEmail(userEmail).get().getId(), photoId)).get());
    }
}
