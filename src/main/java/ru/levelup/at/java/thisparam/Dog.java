package ru.levelup.at.java.thisparam;

public class Dog {

    public static String fourLegs = "4 лапы";

    public static final String TWO_EYES = "2 глаза";

    private String name;
    private String breed;

    public Dog() {
    }

    public Dog(String name) {
        // не считается за ошибку
        // this.name = name;
        // this.breed = "Корги";
        // более красивый вариант
        this(name, "Корги");
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Dog{"
            + "name='" + name + '\''
            + ", breed='" + breed + '\''
            + '}';
    }
}
