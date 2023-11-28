package com.solvd.laba.block1.task3;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final String FILE_URL = "src/main/resources/text.txt";
        final String OUTPUT_FILE = "src/main/resources/result.txt";

        try {
            String text = FileUtils.readFileToString(new File(FILE_URL), StandardCharsets.UTF_8);
            text = StringUtils.lowerCase(text);
            String[] words = StringUtils.split(text);
            words = Arrays.stream(words)
                    .map(word -> word.replaceAll("[.,!?;\"\\-]+", ""))
                    .filter(word -> !word.isBlank())
                    .toArray(String[]::new);
            Set<String> uniqueWords = new HashSet<>(List.of(words));
            FileUtils.write(new File(OUTPUT_FILE), String.valueOf(uniqueWords.size()), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
