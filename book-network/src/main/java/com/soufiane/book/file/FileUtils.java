package com.soufiane.book.file;


import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

@Slf4j
public class FileUtils {

    public static Byte[] readFileFromLocation(String fileUrl) {
        if (StringUtils.isBlank(fileUrl)) {
            return null;
        }
        try {
            Path filePath = new File(fileUrl).toPath();
            byte[] bytes = Files.readAllBytes(filePath);
            // Conversion de byte[] en Byte[]
            return IntStream.range(0, bytes.length)
                    .mapToObj(i -> bytes[i])
                    .toArray(Byte[]::new);
        } catch (IOException e) {
            log.warn("Nou file found in the path {}", fileUrl);
        }
        return null;
    }
}
