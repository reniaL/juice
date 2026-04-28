package com.juice.jdk21.recordpatterns;

public final class RecordPatternsExample {

    private RecordPatternsExample() {
    }

    public static void demo() {
        Developer developer = new Developer("Juice", new Address("Hangzhou"));

        System.out.println("[RecordPatterns] " + describe(developer));
    }

    public static String describe(Object value) {
        if (value instanceof Developer(String name, Address(String city))) {
            return name + " works from " + city;
        }
        return "unknown developer";
    }

    public record Address(String city) {
    }

    public record Developer(String name, Address address) {
    }
}
