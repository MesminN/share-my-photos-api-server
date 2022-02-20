package com.tse.archintiers.photosharing.security.services;

import com.tse.archintiers.photosharing.model.dto.User;
import com.tse.archintiers.photosharing.model.mapper.UserMapper;
import com.tse.archintiers.photosharing.repository.UserRepository;
import com.tse.archintiers.photosharing.security.dto.UserDetailsAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = UserMapper.userEntityToFullUser(userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email: " + email)));

    return UserDetailsAuth.build(user);
  }
}
