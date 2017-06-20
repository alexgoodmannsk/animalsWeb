package ru.alex.clinic;

/**
 * Created by PC1 on 19.06.2017.
 */
public class Dog implements Pet {
    private final Animal animal;

    public Dog(Animal animal) {
        this.animal = animal;
    }

    public String getName() {
        return this.animal.getName();
    }
}
