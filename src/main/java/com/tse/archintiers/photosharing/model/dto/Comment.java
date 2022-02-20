package com.tse.archintiers.photosharing.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private Long id;

    private String commentContent;

    private User member;

    private Photo photo;
}
