package com.juice.jdk21.virtualthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class VirtualThreadsExample {

    private VirtualThreadsExample() {
    }

    public static void demo() {
        try {
            List<String> results = runTasks();
            System.out.println("[VirtualThreads] results: " + results);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Virtual threads demo interrupted", exception);
        } catch (ExecutionException exception) {
            throw new IllegalStateException("Virtual threads demo failed", exception);
        }
    }

    public static List<String> runTasks() throws InterruptedException, ExecutionException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Future<String>> futures = new ArrayList<>();
            futures.add(executor.submit(() -> taskResult("parse markdown")));
            futures.add(executor.submit(() -> taskResult("read examples")));
            futures.add(executor.submit(() -> taskResult("render output")));

            List<String> results = new ArrayList<>();
            for (Future<String> future : futures) {
                results.add(future.get());
            }
            return results;
        }
    }

    private static String taskResult(String action) {
        return action + " on " + Thread.currentThread();
    }
}
