package com.juice.jdk8.defaultmethod;

public interface Notifier {

    String notifyMessage(String message);

    default String notifyWithTag(String tag, String message) {
        return "[" + tag + "] " + notifyMessage(message);
    }

    static String channel() {
        return "console";
    }
}
