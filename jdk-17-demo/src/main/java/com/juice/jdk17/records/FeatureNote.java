package com.juice.jdk17.records;

public record FeatureNote(String name, int releaseYear) {

    public String summary() {
        return name + " (" + releaseYear + ")";
    }
}
