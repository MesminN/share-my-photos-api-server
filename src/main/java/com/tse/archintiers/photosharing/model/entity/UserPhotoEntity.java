package com.tse.archintiers.photosharing.model.entity;

import com.tse.archintiers.photosharing.model.entity.PKs.UserPhotoPK;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="user_photo")
@IdClass(UserPhotoPK.class)
public class UserPhotoEntity {

    @Id
    @Column(name = "user_id", insertable = false, nullable = false)
    private Long userId;

    @Id
    @Column(name = "photo_id", insertable = false, nullable = false)
    private Long photoId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne
    @MapsId("photoId")
    @JoinColumn(nullable = false)
    PhotoEntity photo;

    public UserPhotoEntity(UserEntity user, PhotoEntity photo) {
        this.user = user;
        this.photo = photo;
        this.setPhotoId(photo.getId());
        this.setUserId(user.getId());
    }
}
