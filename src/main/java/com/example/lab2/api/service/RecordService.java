package com.example.lab2.api.service;

import com.example.lab2.api.entity.Record;
import java.util.List;

public interface RecordService {

  List<Record> getAllRecords();

  List<Record> getRecordsByUserId(Long userId);

  List<Record> getRecordsByCategoryId(Long categoryId);

  Record getRecordById(Long id);

  Record createRecord(Record record);

  void deleteRecord(Long id);
}
