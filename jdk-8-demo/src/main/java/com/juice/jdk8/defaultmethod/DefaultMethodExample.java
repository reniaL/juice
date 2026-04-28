package com.juice.jdk8.defaultmethod;

public final class DefaultMethodExample {

    private DefaultMethodExample() {
    }

    public static void demo() {
        Notifier notifier = new EmailNotifier();

        System.out.println("[DefaultMethod] message: " + notifier.notifyWithTag("INFO", "JDK 8 interface default method"));
        System.out.println("[DefaultMethod] channel: " + Notifier.channel());
    }
}
