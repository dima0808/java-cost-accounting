package com.example.lab2.api.service;

import com.example.lab2.api.entity.Category;
import java.util.List;

public interface CategoryService {

  List<Category> getAllCategories();

  Category getCategoryById(Long id);

  Category createCategory(Category category);

  void deleteCategory(Long id);
}
