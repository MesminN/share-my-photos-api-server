package com.tse.archintiers.photosharing.model.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {
    private Long id;

    private String name;

    private String description;

    private String backgroundColor;

    private User user;

    List<Photo> photos;
}
