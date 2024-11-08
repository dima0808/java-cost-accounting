package com.example.lab2.api.service.impl;

import com.example.lab2.api.entity.Record;
import com.example.lab2.api.repository.RecordRepository;
import com.example.lab2.api.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordServiceImpl implements RecordService {

  private final RecordRepository recordRepository;

  public List<Record> getAllRecords() {
    return recordRepository.findAll();
  }

  public List<Record> getRecordsByUserId(Long userId) {
    return recordRepository.findByUserId(userId);
  }

  public List<Record> getRecordsByCategoryId(Long categoryId) {
    return recordRepository.findByCategoryId(categoryId);
  }

  public Record getRecordById(Long id) {
    return recordRepository.findById(id).orElse(null);
  }

  public Record createRecord(Record record) {
    return recordRepository.save(record);
  }

  public void deleteRecord(Long id) {
    recordRepository.deleteById(id);
  }
}
