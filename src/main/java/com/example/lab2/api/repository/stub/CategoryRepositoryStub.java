package com.example.lab2.api.repository.stub;

import com.example.lab2.api.entity.Category;
import com.example.lab2.api.repository.CategoryRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoryRepositoryStub implements CategoryRepository {

  private List<Category> categories = new ArrayList<>();
  private AtomicLong idGenerator = new AtomicLong();

  public List<Category> findAll() {
    return categories;
  }

  public Optional<Category> findById(Long id) {
    return categories.stream().filter(category -> category.getId().equals(id)).findFirst();
  }

  public Category save(Category category) {
    category.setId(idGenerator.incrementAndGet());
    categories.add(category);
    return category;
  }

  public void deleteById(Long id) {
    categories.removeIf(category -> category.getId().equals(id));
  }
}