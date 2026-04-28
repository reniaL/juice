package com.juice.jdk17.patternmatching;

import com.juice.jdk17.sealed.Circle;
import com.juice.jdk17.sealed.Rectangle;
import com.juice.jdk17.sealed.Shape;

public final class PatternMatchingExample {

    private PatternMatchingExample() {
    }

    public static void demo() {
        System.out.println("[PatternMatching] " + describe("juice"));
        System.out.println("[PatternMatching] " + describe(new Circle(3)));
        System.out.println("[PatternMatching] " + describe(new Rectangle(2, 5)));
    }

    public static String describe(Object value) {
        if (value instanceof String text) {
            return "string length=" + text.length();
        }
        if (value instanceof Circle circle) {
            return "circle radius=" + circle.radius();
        }
        if (value instanceof Rectangle rectangle) {
            return "rectangle area=" + rectangle.area();
        }
        if (value instanceof Shape shape) {
            return "shape area=" + shape.area();
        }
        return "unknown value";
    }
}
