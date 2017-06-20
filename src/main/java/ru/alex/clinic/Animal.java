package ru.alex.clinic;

/**
 * Created by PC1 on 19.06.2017.
 */
public class Animal implements Pet {
    private final String name;

    public Animal(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}