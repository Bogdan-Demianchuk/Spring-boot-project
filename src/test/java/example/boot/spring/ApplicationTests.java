package example.boot.spring;

import java.util.List;
import example.boot.spring.Serviсe.FileRiderService;
import example.boot.spring.Serviсe.impl.LocalFileRiderService;
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
                .read("src/test/java/example/boot/spring/resources/TestText");
        Assert.assertEquals(expected, actual);
    }

    @Test
    void contextLoads() {
    }

}
