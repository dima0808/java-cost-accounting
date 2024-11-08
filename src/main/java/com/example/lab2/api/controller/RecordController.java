package com.example.lab2.api.controller;

import com.example.lab2.api.entity.Record;
import com.example.lab2.api.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

  private final RecordService recordService;

  @GetMapping
  public ResponseEntity<List<Record>> getRecords(
      @RequestParam(name = "user_id", required = false) Long userId,
      @RequestParam(name = "category_id", required = false) Long categoryId) {
    List<Record> records;
    if (userId != null && categoryId != null) {
      records = recordService.getRecordsByUserId(userId).stream()
          .filter(record -> record.getCategoryId().equals(categoryId))
          .toList();
    } else if (userId != null) {
      records = recordService.getRecordsByUserId(userId);
    } else if (categoryId != null) {
      records = recordService.getRecordsByCategoryId(categoryId);
    } else {
      throw new IllegalArgumentException("User ID and Category ID is required.");
    }
    return ResponseEntity.ok(records);
  }

  @GetMapping("/{recordId}")
  public ResponseEntity<Record> getRecord(@PathVariable Long recordId) {
    return ResponseEntity.ok(recordService.getRecordById(recordId));
  }

  @PostMapping
  public ResponseEntity<Record> createRecord(@RequestBody Record record) {
    return ResponseEntity.status(HttpStatus.CREATED).body(recordService.createRecord(record));
  }

  @DeleteMapping("/{recordId}")
  public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
    recordService.deleteRecord(recordId);
    return ResponseEntity.noContent().build();
  }
}
