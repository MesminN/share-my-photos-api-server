package com.tse.archintiers.photosharing.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Photo {

    private Long id;

    private String name;

    private String type;

    private String description;

    private String imageValue;

    private Album album;

    private User user;

    public Photo(String name, String desc) {
        this.name = name;
        this.description = desc;
    }

    public Photo(Long id, String name, String type, String description, String imageValue, Album album) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.imageValue = imageValue;
        this.album = album;
    }
}
