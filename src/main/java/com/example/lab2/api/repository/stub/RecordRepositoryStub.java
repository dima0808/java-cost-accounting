package com.example.lab2.api.repository.stub;

import com.example.lab2.api.entity.Record;
import com.example.lab2.api.repository.RecordRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class RecordRepositoryStub implements RecordRepository {

  private List<Record> records = new ArrayList<>();
  private AtomicLong idGenerator = new AtomicLong();

  public List<Record> findAll() {
    return records;
  }

  public Optional<Record> findById(Long id) {
    return records.stream().filter(record -> record.getId().equals(id)).findFirst();
  }

  public List<Record> findByUserId(Long userId) {
    return records.stream().filter(record -> userId.equals(record.getUserId()))
        .collect(Collectors.toList());
  }

  public List<Record> findByCategoryId(Long categoryId) {
    return records.stream().filter(record -> categoryId.equals(record.getCategoryId()))
        .collect(Collectors.toList());
  }

  public Record save(Record record) {
    record.setId(idGenerator.incrementAndGet());
    record.setCreatedAt(LocalDateTime.now());
    records.add(record);
    return record;
  }

  public void deleteById(Long id) {
    records.removeIf(record -> record.getId().equals(id));
  }
}
