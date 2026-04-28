package com.juice.jdk11.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

public final class HttpClientExample {

    private HttpClientExample() {
    }

    public static void demo() {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2))
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://example.com/api/health"))
                .timeout(Duration.ofSeconds(5))
                .header("Accept", "application/json")
                .GET()
                .build();

        System.out.println("[HttpClient] client version: " + client.version());
        System.out.println("[HttpClient] request method: " + request.method());
        System.out.println("[HttpClient] request uri: " + request.uri());
        System.out.println("[HttpClient] request timeout: " + request.timeout().orElse(Duration.ZERO));
    }
}
