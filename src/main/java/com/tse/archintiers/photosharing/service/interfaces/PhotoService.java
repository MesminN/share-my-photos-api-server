package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.Photo;
import com.tse.archintiers.photosharing.model.entity.PhotoEntity;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface PhotoService {

    Photo getPhotoFromUser(Long id, Long userId);

    List<Photo> listPhotosFromUser(Long userId);

    Photo uploadImageForUser(MultipartFile file, String imageDesc, Long albumId, String type, Long userId) throws IOException;

    Photo updatePhotoValue(Photo retrievedPhoto);
}
