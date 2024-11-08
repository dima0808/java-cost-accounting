package com.example.lab2.api.service.impl;

import com.example.lab2.api.entity.User;
import com.example.lab2.api.repository.UserRepository;
import com.example.lab2.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public User createUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
