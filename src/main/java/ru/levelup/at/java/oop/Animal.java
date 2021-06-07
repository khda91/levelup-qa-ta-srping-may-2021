package ru.levelup.at.java.oop;

public abstract class Animal { // extends Object {

    private static final String MALE = "MALE";
    private static final String FEMALE = "FEMALE";

    private String name;
    private int length;
    private int weight;
    private int age;
    private int lifeLength;
    private String color;
    protected Gender gender;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public abstract void move();

    public Gender getGender() {
        return gender;
    }

    //    public void setGender(String gender) {
    //        if (!(MALE.equals(gender) || FEMALE.equals(gender))) {
    //            throw new IllegalArgumentException("unknown gender");
    //        }
    //        this.gender = gender;
    //    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLifeLength() {
        return lifeLength;
    }

    public void setLifeLength(int lifeLength) {
        this.lifeLength = lifeLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{"
            + "name='" + name + '\''
            + ", length=" + length
            + ", weight=" + weight
            + ", age=" + age
            + ", lifeLength=" + lifeLength
            + ", color=" + color
            + '}';
    }
}
