package com.juice.jdk11.filesapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FilesApiExample {

    private FilesApiExample() {
    }

    public static void demo() {
        try {
            String fileContent = writeAndRead();
            System.out.println("[Files] read content: " + fileContent);
        } catch (IOException exception) {
            throw new IllegalStateException("Files API demo failed", exception);
        }
    }

    public static String writeAndRead() throws IOException {
        Path tempFile = Files.createTempFile("juice-jdk11-", ".txt");
        try {
            Files.writeString(tempFile, "JDK 11 Files API");
            return Files.readString(tempFile);
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}
