package com.tse.archintiers.photosharing.repository;

import com.tse.archintiers.photosharing.model.entity.AlbumEntity;
import com.tse.archintiers.photosharing.model.entity.PhotoEntity;
import com.tse.archintiers.photosharing.model.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
    PhotoEntity findByIdAndUser(Long albumId, UserEntity userId);
    List<PhotoEntity> findAllByUser(UserEntity user);
    List<PhotoEntity> findAllByAlbum(AlbumEntity album);
}
