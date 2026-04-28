package com.juice.jdk17.helpfulnpe;

public final class HelpfulNullPointerExample {

    private HelpfulNullPointerExample() {
    }

    public static void demo() {
        try {
            lengthOfOwnerName(new Project(new Owner(null)));
        } catch (NullPointerException exception) {
            System.out.println("[HelpfulNPE] message: " + exception.getMessage());
        }
    }

    public static int lengthOfOwnerName(Project project) {
        return project.owner().name().length();
    }

    public record Owner(String name) {
    }

    public record Project(Owner owner) {
    }
}
