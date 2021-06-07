package ru.levelup.at.java.oop;

public class Cat extends HouseAnimal implements Eatable {

    private String eyeColor;

    public Cat() {
    }

    public Cat(String name, Gender sex) {
        super(name);
        super.gender = sex;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public void move() {
        if (Gender.MALE.equals(gender)) {
            System.out.println("Я слишком ленив чтобы прыгать");
        } else {
            System.out.println("А вкусняшку мне дадут?");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nCat{"
            + "eyeColor='" + eyeColor + '\''
            + '}';
    }

    @Override
    public String eat(String food) {
        return "Ммммм... " + food + " Ням-ням:) ";
    }
}
