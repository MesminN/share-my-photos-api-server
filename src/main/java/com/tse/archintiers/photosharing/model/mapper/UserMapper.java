package com.tse.archintiers.photosharing.model.mapper;


import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.entity.UserEntity;

public class UserMapper {
    public static UserEntity userToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        if(user.getId() != null) {
            userEntity.setId(user.getId());
        }
        if(user.getEmail() != null) {
            userEntity.setEmail(user.getEmail());
        }
        if(user.getPassword() != null) {
            userEntity.setPassword(user.getPassword());
        }
        if(user.getFirstName() != null) {
            userEntity.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null) {
            userEntity.setLastName(user.getLastName());
        }
        return userEntity;
    }

    public static User userEntityToUser(UserEntity userEntity) {
        User user = new User();
        if(userEntity.getId() != null) {
            user.setId(userEntity.getId());
        }
        if(userEntity.getEmail() != null) {
            user.setEmail(userEntity.getEmail());
        }
        if(userEntity.getFirstName() != null) {
            user.setFirstName(userEntity.getFirstName());
        }
        if(userEntity.getLastName() != null) {
            user.setLastName(userEntity.getLastName());
        }
        return user;
    }

    public static User userEntityToFullUser(UserEntity userEntity) {
        User user = new User();
        if(userEntity.getId() != null) {
            user.setId(userEntity.getId());
        }
        if(userEntity.getEmail() != null) {
            user.setEmail(userEntity.getEmail());
        }
        if(userEntity.getPassword() != null) {
            user.setPassword(userEntity.getPassword());
        }
        if(userEntity.getFirstName() != null) {
            user.setFirstName(userEntity.getFirstName());
        }
        if(userEntity.getLastName() != null) {
            user.setLastName(userEntity.getLastName());
        }
        return user;
    }
}
