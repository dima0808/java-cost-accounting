package com.example.lab2.api.repository.stub;

import com.example.lab2.api.entity.User;
import com.example.lab2.api.repository.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepositoryStub implements UserRepository {

  private List<User> users = new ArrayList<>();
  private AtomicLong idGenerator = new AtomicLong();

  public List<User> findAll() {
    return users;
  }

  public Optional<User> findById(Long id) {
    return users.stream().filter(user -> user.getId().equals(id)).findFirst();
  }

  public User save(User user) {
    user.setId(idGenerator.incrementAndGet());
    users.add(user);
    return user;
  }

  public void deleteById(Long id) {
    users.removeIf(user -> user.getId().equals(id));
  }
}
