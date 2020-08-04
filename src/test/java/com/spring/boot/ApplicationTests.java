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
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    FileReaderService fileRiderService = new LocalFileReaderService();

    @Test
    public void readCorrect() {
        List<String> expected = List.of("Hello", "Fiend d");
        List<String> actual = fileRiderService
                .read("src/test/java/com/spring/boot/resources/TestText");
        Assert.assertEquals(expected, actual);
    }



    @Test
    void contextLoads() {
    }
}
