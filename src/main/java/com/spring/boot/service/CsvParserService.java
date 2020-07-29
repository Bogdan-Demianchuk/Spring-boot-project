package com.spring.boot.service;

import java.util.List;

public interface CsvParserService<T> {
    List<T> parcFromCsvToObjects(String path);
}
