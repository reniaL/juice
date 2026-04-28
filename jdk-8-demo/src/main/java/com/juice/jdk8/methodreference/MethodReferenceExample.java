package com.juice.jdk8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public final class MethodReferenceExample {

    private MethodReferenceExample() {
    }

    public static void demo() {
        List<String> rawNumbers = Arrays.asList("10", "2", "35");
        List<String> rawWords = Arrays.asList("  juice  ", "  java  ", "  lambda  ");

        List<Integer> parsedNumbers = map(rawNumbers, Integer::parseInt);
        List<String> trimmedWords = map(rawWords, String::trim);
        Supplier<StringBuilder> builderSupplier = StringBuilder::new;
        String builtText = builderSupplier.get()
                .append("method")
                .append(" reference")
                .toString();

        System.out.println("[MethodReference] parsed numbers: " + parsedNumbers);
        System.out.println("[MethodReference] trimmed words: " + trimmedWords);
        System.out.println("[MethodReference] constructor reference: " + builtText);
    }

    public static <T, R> List<R> map(List<T> source, Function<T, R> mapper) {
        return source.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
