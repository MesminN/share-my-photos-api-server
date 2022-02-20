package com.tse.archintiers.photosharing.model.entity;

import com.tse.archintiers.photosharing.model.entity.PKs.UserAlbumPK;
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
@Table(name="user_album")
@IdClass(UserAlbumPK.class)
public class UserAlbumEntity {

    @Id
    @Column(name = "user_id", insertable = false, nullable = false)
    private Long userId;

    @Id
    @Column(name = "album_id", insertable = false, nullable = false)
    private Long albumId;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(nullable = false)
    private UserEntity user;

    @ManyToOne
    @MapsId("albumId")
    @JoinColumn(nullable = false)
    AlbumEntity album;

    public UserAlbumEntity(UserEntity user, AlbumEntity album) {
        this.user = user;
        this.album = album;
        this.setAlbumId(album.getId());
        this.setUserId(user.getId());
    }
}
