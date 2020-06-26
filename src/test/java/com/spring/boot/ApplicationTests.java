package com.spring.boot;

import java.util.List;
import com.spring.boot.service.impl.LocalFileRiderService;
import com.spring.boot.service.FileRiderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
    FileRiderService fileRiderService = new LocalFileRiderService();

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
