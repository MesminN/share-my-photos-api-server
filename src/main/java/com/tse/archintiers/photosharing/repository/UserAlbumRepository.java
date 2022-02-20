package com.tse.archintiers.photosharing.repository;

import com.tse.archintiers.photosharing.model.entity.PKs.UserAlbumPK;
import com.tse.archintiers.photosharing.model.entity.UserAlbumEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAlbumRepository extends JpaRepository<UserAlbumEntity, UserAlbumPK> {
    List<UserAlbumEntity> findAllByUserId(Long userId);

    UserAlbumEntity findByUserId(Long userId);
}
