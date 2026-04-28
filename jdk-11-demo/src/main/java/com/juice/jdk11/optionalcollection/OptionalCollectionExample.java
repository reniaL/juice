package com.juice.jdk11.optionalcollection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class OptionalCollectionExample {

    private OptionalCollectionExample() {
    }

    public static void demo() {
        Optional<String> empty = Optional.empty();
        List<String> values = Arrays.asList("juice", " ", "java", "", "jdk11");

        List<String> filtered = values.stream()
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.toList());
        String[] array = filtered.toArray(String[]::new);

        System.out.println("[Optional/Collection] optional isEmpty: " + empty.isEmpty());
        System.out.println("[Optional/Collection] filtered values: " + filtered);
        System.out.println("[Optional/Collection] toArray result: " + Arrays.toString(array));
    }
}
