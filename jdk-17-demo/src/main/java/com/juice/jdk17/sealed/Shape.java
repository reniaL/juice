package com.juice.jdk17.sealed;

public sealed interface Shape permits Circle, Rectangle {

    double area();
}
