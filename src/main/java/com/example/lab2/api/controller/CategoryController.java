package com.example.lab2.api.controller;

import com.example.lab2.api.entity.Category;
import com.example.lab2.api.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<List<Category>> getAllCategories() {
    return ResponseEntity.ok(categoryService.getAllCategories());
  }

  @GetMapping("/{categoryId}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
    return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
  }

  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
  }

  @DeleteMapping("/{categoryId}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long categoryId) {
    categoryService.deleteCategory(categoryId);
    return ResponseEntity.noContent().build();
  }
}