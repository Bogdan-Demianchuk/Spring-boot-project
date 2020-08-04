package com.spring.boot.service.impl;

import com.spring.boot.service.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class LocalFileReaderService implements FileReaderService {
    @Override
    public List<String> read(String path) {
        List<String> result;
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            result = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file");
        }
        return result;
    }
}
