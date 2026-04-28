package com.juice.jdk8.defaultmethod;

public final class EmailNotifier implements Notifier {

    @Override
    public String notifyMessage(String message) {
        return "Send mail: " + message;
    }
}
