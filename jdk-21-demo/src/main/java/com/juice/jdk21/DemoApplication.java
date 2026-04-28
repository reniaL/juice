package com.juice.jdk21;

import com.juice.jdk21.recordpatterns.RecordPatternsExample;
import com.juice.jdk21.sequencedcollections.SequencedCollectionsExample;
import com.juice.jdk21.switchpattern.SwitchPatternExample;
import com.juice.jdk21.virtualthreads.VirtualThreadsExample;

public final class DemoApplication {

    private DemoApplication() {
    }

    public static void main(String[] args) {
        System.out.println("juice: JDK 21 feature showcase");
        System.out.println();

        VirtualThreadsExample.demo();
        RecordPatternsExample.demo();
        SwitchPatternExample.demo();
        SequencedCollectionsExample.demo();
    }
}
