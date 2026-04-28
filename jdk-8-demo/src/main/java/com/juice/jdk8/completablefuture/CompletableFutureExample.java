package com.juice.jdk8.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public final class CompletableFutureExample {

    private CompletableFutureExample() {
    }

    public static void demo() {
        try {
            System.out.println("[CompletableFuture] result: " + buildMessage());
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("CompletableFuture demo interrupted", exception);
        } catch (ExecutionException exception) {
            throw new IllegalStateException("CompletableFuture demo failed", exception);
        }
    }

    public static String buildMessage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "juice")
                .thenApply(String::toUpperCase)
                .thenApply(value -> value + " uses CompletableFuture");
        return future.get();
    }
}
