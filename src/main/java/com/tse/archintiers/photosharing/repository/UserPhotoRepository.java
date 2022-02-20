package com.tse.archintiers.photosharing.repository;

import com.tse.archintiers.photosharing.model.entity.PKs.UserPhotoPK;
import com.tse.archintiers.photosharing.model.entity.UserPhotoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPhotoRepository extends JpaRepository<UserPhotoEntity, UserPhotoPK> {
    List<UserPhotoEntity> findAllByUserId(Long userId);

    UserPhotoEntity findByUserId(Long userId);
}
