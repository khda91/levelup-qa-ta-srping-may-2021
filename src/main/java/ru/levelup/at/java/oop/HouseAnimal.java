package ru.levelup.at.java.oop;

import java.io.Serializable;

public abstract class HouseAnimal extends Animal implements Eatable, Serializable {

    private String breed;
    //    private String sex;

    public HouseAnimal() {

    }

    public HouseAnimal(String name) {
        super(name);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    // реализация абстрактного метода
    //    @Override
    //    public void move() {
    //
    //    }
}
