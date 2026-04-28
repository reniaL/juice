package com.juice.jdk17;

import com.juice.jdk17.helpfulnpe.HelpfulNullPointerExample;
import com.juice.jdk17.patternmatching.PatternMatchingExample;
import com.juice.jdk17.records.RecordExample;
import com.juice.jdk17.sealed.SealedClassExample;
import com.juice.jdk17.textblocks.TextBlocksExample;

public final class DemoApplication {

    private DemoApplication() {
    }

    public static void main(String[] args) {
        System.out.println("juice: JDK 17 feature showcase");
        System.out.println();

        RecordExample.demo();
        SealedClassExample.demo();
        PatternMatchingExample.demo();
        TextBlocksExample.demo();
        HelpfulNullPointerExample.demo();
    }
}
