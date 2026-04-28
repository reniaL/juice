package com.juice.jdk17.sealed;

public final class SealedClassExample {

    private SealedClassExample() {
    }

    public static void demo() {
        Shape circle = new Circle(2);
        Shape rectangle = new Rectangle(3, 4);

        System.out.println("[Sealed] circle area: " + circle.area());
        System.out.println("[Sealed] rectangle area: " + rectangle.area());
    }
}
