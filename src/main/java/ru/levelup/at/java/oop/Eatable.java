package ru.levelup.at.java.oop;

public interface Eatable {

    String FOOD = "Хавка";

    //    String eat(String food);

    default String eat(String food) {
        return "Ура! Еда! " + food;
    }
}
