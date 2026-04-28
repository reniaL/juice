package com.juice.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class StreamExample {

    private StreamExample() {
    }

    public static void demo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenSquares = collectEvenSquares(numbers);
        Map<String, List<String>> groupedNames = groupNamesByFirstLetter(Arrays.asList("Alice", "Amy", "Bob", "Brian"));

        System.out.println("[Stream] even squares: " + evenSquares);
        System.out.println("[Stream] grouped names: " + groupedNames);
    }

    public static List<Integer> collectEvenSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .map(number -> number * number)
                .collect(Collectors.toList());
    }

    public static Map<String, List<String>> groupNamesByFirstLetter(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(name -> String.valueOf(name.charAt(0))));
    }
}
