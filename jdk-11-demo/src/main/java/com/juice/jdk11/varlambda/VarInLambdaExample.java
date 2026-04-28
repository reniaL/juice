package com.juice.jdk11.varlambda;

import java.util.function.BiFunction;

public final class VarInLambdaExample {

    private VarInLambdaExample() {
    }

    public static void demo() {
        BiFunction<String, String, String> joiner = (var left, var right) -> left + " -> " + right;

        System.out.println("[var in lambda] " + joiner.apply("JDK 11", "lambda parameters"));
    }
}
