package com.example.lab2.api.service.impl;

import com.example.lab2.api.entity.Category;
import com.example.lab2.api.repository.CategoryRepository;
import com.example.lab2.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getCategoryById(Long id) {
    return categoryRepository.findById(id).orElse(null);
  }

  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
}
