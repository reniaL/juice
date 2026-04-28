package com.juice.jdk17.records;

public final class RecordExample {

    private RecordExample() {
    }

    public static void demo() {
        FeatureNote record = new FeatureNote("record", 2021);
        FeatureNote sameRecord = new FeatureNote("record", 2021);

        System.out.println("[Record] summary: " + record.summary());
        System.out.println("[Record] name accessor: " + record.name());
        System.out.println("[Record] value equality: " + record.equals(sameRecord));
    }
}
