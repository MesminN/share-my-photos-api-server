package com.tse.archintiers.photosharing.service.interfaces;

import com.tse.archintiers.photosharing.model.dto.User;
import java.util.List;

public interface UserService {

    User getUser(Long id);

    Boolean isUserPresent(String email);

    List<User> listUsers();

    User createNewUser(User user);
}
