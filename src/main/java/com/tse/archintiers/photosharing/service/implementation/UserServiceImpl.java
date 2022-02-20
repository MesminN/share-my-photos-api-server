package com.tse.archintiers.photosharing.service.implementation;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.mapper.UserMapper;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.service.interfaces.UserService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return UserMapper.userEntityToUser(userRepository.getById(id));
    }

    @Override
    public Boolean isUserPresent(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll().stream().map(UserMapper::userEntityToUser).collect(Collectors.toList());
    }

    @Override
    public User createNewUser(User user) {
        return UserMapper.userEntityToUser(userRepository.save(UserMapper.userToUserEntity(user)));
    }
}