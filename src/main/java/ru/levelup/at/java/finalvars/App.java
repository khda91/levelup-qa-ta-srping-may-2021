package ru.levelup.at.java.finalvars;

import ru.levelup.at.java.thisparam.Dog;

public class App {

    public static void main(String[] args) {
        final int a = 3;
        //        a = 8; нелья присвоить значение final primitives

        final Dog dog = new Dog("Коржик");
        // dog = new Dog("Вовка"); нелья изменить значение ссылки
        dog.setBreed("Шпиц");
        System.out.println(dog);
    }
}
