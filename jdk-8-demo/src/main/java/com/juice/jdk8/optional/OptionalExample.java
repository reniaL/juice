package com.juice.jdk8.optional;

import java.util.Optional;

public final class OptionalExample {

    private OptionalExample() {
    }

    public static void demo() {
        String nickname = findNickname("juice").orElse("guest");
        String fallback = findNickname("unknown").orElseGet(() -> "default-user");

        System.out.println("[Optional] known nickname: " + nickname);
        System.out.println("[Optional] fallback nickname: " + fallback);
    }

    public static Optional<String> findNickname(String account) {
        if ("juice".equals(account)) {
            return Optional.of("juicy-coder");
        }
        return Optional.empty();
    }
}
