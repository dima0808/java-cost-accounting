package com.example.lab2.api.config;

import com.example.lab2.api.entity.Category;
import com.example.lab2.api.entity.Record;
import com.example.lab2.api.entity.User;
import com.example.lab2.api.service.CategoryService;
import com.example.lab2.api.service.RecordService;
import com.example.lab2.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final UserService userService;
  private final CategoryService categoryService;
  private final RecordService recordService;

  @Override
  public void run(String... args) {
    // Create users
    List<User> users = Arrays.asList(
        new User(null, "User1"),
        new User(null, "User2"),
        new User(null, "User3"),
        new User(null, "User4")
    );
    users.forEach(userService::createUser);

    // Create categories
    List<Category> categories = Arrays.asList(
        new Category(null, "Category1"),
        new Category(null, "Category2"),
        new Category(null, "Category3"),
        new Category(null, "Category4"),
        new Category(null, "Category5"),
        new Category(null, "Category6")
    );
    categories.forEach(categoryService::createCategory);

    // Create records for each user
    users.forEach(user -> {
      for (int i = 1; i <= 5; i++) {
        Record record = new Record();
        record.setUserId(user.getId());
        record.setCategoryId(randomCategory(categories).getId());
        record.setAmount(100.0 * i);
        recordService.createRecord(record);
      }
    });
  }

  private static Category randomCategory(List<Category> categories) {
    return categories.get((int) (Math.random() * categories.size()));
  }
}
