package ru.levelup.at.java.thisparam;

public class App {

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.println("Dog1 -> " + dog1);
        dog1.setName("Шарик");
        System.out.println("After dog1.setName(...)");
        System.out.println("Dog1 -> " + dog1);

        System.out.println();
        System.out.println(Dog.fourLegs);

        Dog dog2 = new Dog("Сайрус");
        //        System.out.println(dog2.getName() + " has " + dog2.fourLegs); не желательный вариант
        System.out.println(dog2.getName() + " has " + Dog.fourLegs); // более предпочтительный вариант доступа к static

        System.out.println();
        System.out.println();

        System.out.println(dog2.getName() + " has " + dog2.fourLegs);
        System.out.println(dog1.getName() + " has " + Dog.fourLegs);

        Dog dog3 = new Dog("Вовка", "немецкая овчарка");
        dog3.fourLegs = "хвост";

        System.out.println(dog3.getName() + " has " + dog3.fourLegs);

        System.out.println();
        System.out.println();
        System.out.println(dog2.getName() + " has " + dog2.fourLegs);
        System.out.println(dog1.getName() + " has " + Dog.fourLegs);
    }
}
