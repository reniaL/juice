package com.juice.jdk8;

import com.juice.jdk8.collectors.CollectorsExample;
import com.juice.jdk8.completablefuture.CompletableFutureExample;
import com.juice.jdk8.datetime.DateTimeExample;
import com.juice.jdk8.defaultmethod.DefaultMethodExample;
import com.juice.jdk8.functionalinterface.FunctionalInterfaceExample;
import com.juice.jdk8.lambda.LambdaExample;
import com.juice.jdk8.methodreference.MethodReferenceExample;
import com.juice.jdk8.optional.OptionalExample;
import com.juice.jdk8.stream.StreamExample;

public final class DemoApplication {

    private DemoApplication() {
    }

    public static void main(String[] args) {
        System.out.println("juice: JDK 8 feature showcase");
        System.out.println();

        LambdaExample.demo();
        MethodReferenceExample.demo();
        FunctionalInterfaceExample.demo();
        StreamExample.demo();
        CollectorsExample.demo();
        OptionalExample.demo();
        DefaultMethodExample.demo();
        DateTimeExample.demo();
        CompletableFutureExample.demo();
    }
}
