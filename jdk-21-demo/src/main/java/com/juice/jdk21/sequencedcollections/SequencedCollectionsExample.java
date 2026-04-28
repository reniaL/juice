package com.juice.jdk21.sequencedcollections;

import java.util.ArrayList;
import java.util.List;

public final class SequencedCollectionsExample {

    private SequencedCollectionsExample() {
    }

    public static void demo() {
        List<String> versions = new ArrayList<>(List.of("JDK 8", "JDK 11", "JDK 17"));
        versions.addFirst("JDK 7");
        versions.addLast("JDK 21");

        System.out.println("[SequencedCollections] first: " + versions.getFirst());
        System.out.println("[SequencedCollections] last: " + versions.getLast());
        System.out.println("[SequencedCollections] reversed: " + versions.reversed());
    }
}
