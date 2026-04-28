package com.juice.jdk11.stringapi;

import java.util.List;
import java.util.stream.Collectors;

public final class StringApiExample {

    private StringApiExample() {
    }

    public static void demo() {
        String raw = "  juice java\nstream api\n\n";
        String blank = "   \t";
        List<String> lines = raw.lines().collect(Collectors.toList());

        System.out.println("[String] isBlank: " + blank.isBlank());
        System.out.println("[String] strip: '" + raw.strip() + "'");
        System.out.println("[String] repeat: " + "na".repeat(3));
        System.out.println("[String] lines: " + lines);
    }
}
