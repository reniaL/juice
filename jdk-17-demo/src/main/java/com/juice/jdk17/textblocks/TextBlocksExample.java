package com.juice.jdk17.textblocks;

public final class TextBlocksExample {

    private TextBlocksExample() {
    }

    public static void demo() {
        String json = """
                {
                  "project": "juice",
                  "topic": "JDK 17",
                  "feature": "text blocks"
                }
                """;

        String sql = """
                SELECT feature_name, release_year
                FROM jdk_features
                WHERE release_year >= 2021
                ORDER BY feature_name
                """;

        System.out.println("[TextBlocks] json:\n" + json);
        System.out.println("[TextBlocks] sql:\n" + sql);
    }
}
