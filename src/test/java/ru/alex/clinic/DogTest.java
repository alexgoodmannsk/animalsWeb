package ru.alex.clinic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PC1 on 19.06.2017.
 */
public class DogTest {

    @Test
    public void getNameTest(){
        Dog dog = new Dog(new Animal("test"));
        assertEquals("test", dog.getName());
    }

}