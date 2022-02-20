package com.tse.archintiers.photosharing.repository;

import com.tse.archintiers.photosharing.model.entity.AlbumEntity;
import com.tse.archintiers.photosharing.model.entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {
    AlbumEntity findByIdAndUser(Long albumId, UserEntity userId);
    List<AlbumEntity> findAllByUser(UserEntity userId);
}
