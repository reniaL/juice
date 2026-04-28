package com.juice.jdk21.switchpattern;

public final class SwitchPatternExample {

    private SwitchPatternExample() {
    }

    public static void demo() {
        System.out.println("[SwitchPattern] " + describe("juice"));
        System.out.println("[SwitchPattern] " + describe("   "));
        System.out.println("[SwitchPattern] " + describe(21));
        System.out.println("[SwitchPattern] " + describe(-1));
        System.out.println("[SwitchPattern] " + describe(null));
    }

    public static String describe(Object value) {
        return switch (value) {
            case null -> "null value";
            case String text when text.isBlank() -> "blank string";
            case String text -> "text=" + text.toUpperCase();
            case Integer number when number > 0 -> "positive integer=" + number;
            case Integer number -> "non-positive integer=" + number;
            default -> "unsupported value=" + value;
        };
    }
}
