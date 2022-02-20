package com.tse.archintiers.photosharing.model.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "Photo")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "description")
    protected String description;

    @Transient
    protected String imageValue;

    @ManyToOne
    private AlbumEntity album;

    @ManyToOne
    @JoinColumn(name="created_by", nullable = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "photo")
    Set<UserPhotoEntity> userPhotos = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "photo")
    Set<CommentEntity> comments = new HashSet<>();

    public PhotoEntity(String name, String desc) {
        this.name = name;
        this.description = desc;
    }
}
