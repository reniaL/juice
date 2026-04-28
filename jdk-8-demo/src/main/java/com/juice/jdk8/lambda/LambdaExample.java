package com.juice.jdk8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class LambdaExample {

    private LambdaExample() {
    }

    public static void demo() {
        List<String> words = Arrays.asList("pear", "apple", "banana", "kiwi");
        List<String> sortedWords = sortByLength(words);

        System.out.println("[Lambda] sort by length: " + sortedWords);
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(String::compareTo))
                .collect(Collectors.toList());
    }
}
