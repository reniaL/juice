package com.juice.jdk8.functionalinterface;

@FunctionalInterface
public interface TextFormatter {

    String format(String text);

    default String formatWithPrefix(String prefix, String text) {
        return prefix + format(text);
    }
}
