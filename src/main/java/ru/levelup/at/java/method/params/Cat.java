package ru.levelup.at.java.method.params;

public class Cat {

    private String name;
    private String breed;

    public Cat() {
    }

    public Cat(String name, String breed) {
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
        return "Cat{"
            + "name='" + name + '\''
            + ", breed='" + breed + '\''
            + '}';
    }
}
