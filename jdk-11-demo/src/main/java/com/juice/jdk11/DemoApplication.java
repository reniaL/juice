package com.juice.jdk11;

import com.juice.jdk11.filesapi.FilesApiExample;
import com.juice.jdk11.httpclient.HttpClientExample;
import com.juice.jdk11.optionalcollection.OptionalCollectionExample;
import com.juice.jdk11.stringapi.StringApiExample;
import com.juice.jdk11.varlambda.VarInLambdaExample;

public final class DemoApplication {

    private DemoApplication() {
    }

    public static void main(String[] args) {
        System.out.println("juice: JDK 11 feature showcase");
        System.out.println();

        HttpClientExample.demo();
        StringApiExample.demo();
        FilesApiExample.demo();
        VarInLambdaExample.demo();
        OptionalCollectionExample.demo();
    }
}
