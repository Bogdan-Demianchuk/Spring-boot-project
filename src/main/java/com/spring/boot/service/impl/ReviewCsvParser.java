package com.spring.boot.service.impl;

import com.spring.boot.mapper.ReviewMapper;
import com.spring.boot.model.dto.ReviewDto;
import com.spring.boot.service.CsvParserService;
import com.spring.boot.service.FileReaderService;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ReviewCsvParser implements CsvParserService {
    private final FileReaderService fileRiderService;
    private final ReviewMapper reviewMapper;

    public ReviewCsvParser(FileReaderService fileRiderService, ReviewMapper reviewMapper) {
        this.fileRiderService = fileRiderService;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewDto> parseCsvFile(String path) {
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        CsvParserSettings csvParserSettings = new CsvParserSettings();
        csvParserSettings.setMaxCharsPerColumn(-1);
        CsvParser csvParser = new CsvParser(csvParserSettings);
        List<String> lines = fileRiderService.read(path);
        lines.remove(0);
        for (String line : lines) {
            String[] reviewContent = csvParser.parseLine(line);
            reviewDtoList.add(reviewMapper.getReviewDtoFromLine(reviewContent));
        }
        return reviewDtoList;
    }
}
