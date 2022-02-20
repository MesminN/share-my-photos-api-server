package com.tse.archintiers.photosharing.model.mapper;

import com.tse.archintiers.photosharing.model.dto.Comment;
import com.tse.archintiers.photosharing.model.entity.CommentEntity;

public class CommentMapper {

    public static CommentEntity commentToCommentEntity(Comment comment) {
        CommentEntity returnedCommentEntity = new CommentEntity();
        if(comment.getId() != null) {
            returnedCommentEntity.setId(comment.getId());
        }
        if(comment.getCommentContent() != null) {
            returnedCommentEntity.setCommentContent(comment.getCommentContent());
        }
        if(comment.getMember() != null) {
            returnedCommentEntity.setUser(UserMapper.userToUserEntity(comment.getMember()));
        }
        if(comment.getPhoto() != null) {
            returnedCommentEntity.setPhoto(PhotoMapper.photoToPhotoEntity(comment.getPhoto()));
        }

        return returnedCommentEntity;
    }

    public static Comment commentEntityToComment(CommentEntity commentEntity) {
        Comment returnedComment = new Comment();
        if(commentEntity.getId() != null) {
            returnedComment.setId(commentEntity.getId());
        }
        if(commentEntity.getCommentContent() != null) {
            returnedComment.setCommentContent(commentEntity.getCommentContent());
        }
        if(commentEntity.getUser() != null) {
            returnedComment.setMember(UserMapper.userEntityToUser(commentEntity.getUser()));
        }

        return returnedComment;
    }
}
