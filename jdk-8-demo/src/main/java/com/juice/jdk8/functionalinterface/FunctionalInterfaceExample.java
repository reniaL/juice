package com.juice.jdk8.functionalinterface;

public final class FunctionalInterfaceExample {

    private FunctionalInterfaceExample() {
    }

    public static void demo() {
        TextFormatter formatter = text -> text.trim().toUpperCase();
        String formatted = apply("  juice and java  ", formatter);

        System.out.println("[FunctionalInterface] formatted text: " + formatted);
        System.out.println("[FunctionalInterface] with prefix: "
                + formatter.formatWithPrefix("Result: ", "  lambda  "));
    }

    public static String apply(String text, TextFormatter formatter) {
        return formatter.format(text);
    }
}
