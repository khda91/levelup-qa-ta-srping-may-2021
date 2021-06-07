package ru.levelup.at.java.oop;

public class Dog extends HouseAnimal {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void move() {
        System.out.println("бегом");
    }

    @Override
    public String toString() {
        return "Dog{"
            + "type='" + type + '\''
            + '}';
    }

    //    @Override
    //    public String eat(String food) {
    //        return "Йуху!!! Еда просто объедение. А на обед сегодня " + food;
    //    }
}
