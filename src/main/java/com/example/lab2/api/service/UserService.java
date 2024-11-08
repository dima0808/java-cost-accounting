package com.example.lab2.api.service;

import com.example.lab2.api.entity.User;
import java.util.List;

public interface UserService {

  List<User> getAllUsers();

  User getUserById(Long id);

  User createUser(User user);

  void deleteUser(Long id);
}
