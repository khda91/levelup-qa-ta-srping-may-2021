package ru.levelup.at.java.oop;

public class Utils {

    public static Animal createAnimal(String name) {
        var animal = new Cat();
        animal.setName(name);
        return animal;
    }
}
