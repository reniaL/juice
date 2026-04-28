package com.juice.jdk8.collectors;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class CollectorsExample {

    private CollectorsExample() {
    }

    public static void demo() {
        List<String> features = Arrays.asList("lambda", "stream", "optional", "time", "future");

        Map<Boolean, List<String>> partitioned = partitionByLength(features, 7);
        String joined = joinUppercase(features);
        IntSummaryStatistics statistics = summarizeLengths(features);

        System.out.println("[Collectors] partitioned by length >= 7: " + partitioned);
        System.out.println("[Collectors] joined uppercase: " + joined);
        System.out.println("[Collectors] summary: count=" + statistics.getCount()
                + ", min=" + statistics.getMin()
                + ", max=" + statistics.getMax()
                + ", average=" + statistics.getAverage());
    }

    public static Map<Boolean, List<String>> partitionByLength(List<String> values, int minLength) {
        return values.stream()
                .collect(Collectors.partitioningBy(value -> value.length() >= minLength));
    }

    public static String joinUppercase(List<String> values) {
        return values.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(", "));
    }

    public static IntSummaryStatistics summarizeLengths(List<String> values) {
        return values.stream()
                .collect(Collectors.summarizingInt(String::length));
    }
}
