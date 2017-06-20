package ru.alex.clinic;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PC1 on 19.06.2017.
 */
public class AnimalTest {
    @Test
    public void getNameTest(){
        Animal animal = new Animal("test");
        assertEquals("test", animal.getName());
    }


}