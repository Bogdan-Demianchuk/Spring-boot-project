package com.spring.boot;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import com.spring.boot.mapper.ReviewMapper;
import com.spring.boot.model.dto.ReviewDto;
import com.spring.boot.service.FileReaderService;
import com.spring.boot.service.impl.LocalFileReaderService;
import com.spring.boot.service.impl.ReviewCsvParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ParseCsvFileTest {
    FileReaderService fileRiderService = new LocalFileReaderService();
    ReviewMapper reviewMapper = new ReviewMapper();
    ReviewCsvParser reviewCsvParser = new ReviewCsvParser(fileRiderService, reviewMapper);

    @Test
    void correctParseFromPathToObjects() {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setProductId("B001E4KFG0");
        reviewDto.setUserId("A3SGXH7AUHU8GW");
        reviewDto.setProfileName("delmartian");
        reviewDto.setHelpfulnessNominator(1L);
        reviewDto.setHelpfulnessDenominator(1L);
        reviewDto.setScore(5L);
        reviewDto.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1303862400L),
                TimeZone.getDefault().toZoneId()));
        reviewDto.setSummary("Good Quality Dog Food");
        reviewDto.setText("I have bought several of the Vitality canned dog food products and have found them all to be of good quality. The product looks more like a stew than a processed meat and it smells better. My Labrador is finicky and she appreciates this product better than  most.");
        List<ReviewDto> expected = List.of(reviewDto);
        List<ReviewDto> actual = reviewCsvParser.parseCsvFile("src/test/java/com/spring/boot/resources/TEST.csv");
        Assert.assertEquals(expected, actual);
    }
}