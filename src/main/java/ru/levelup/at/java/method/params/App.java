package ru.levelup.at.java.method.params;

public class App {

    public static void main(String[] args) {
        System.out.println("==============");
        System.out.println("PRIMITIVES");
        System.out.println("==============");

        int number1 = 4;
        x2(number1);
        System.out.println("number: " + number1);

        int number2 = returnX2(number1);
        System.out.println("number: " + number2);

        System.out.println();
        System.out.println();
        System.out.println("==============");
        System.out.println("OBJECTS");
        System.out.println("==============");

        // v1
        System.out.println("changeCatName V1");
        Cat cat1 = new Cat("При", "Мэйкун");
        changeCatNameV1(cat1);
        System.out.println("Cat: " + cat1);

        System.out.println();

        // v2
        System.out.println("changeCatName V2");
        cat1 = new Cat("При", "Мэйкун");
        changeCatNameV2(cat1);
        System.out.println("Cat: " + cat1);

        System.out.println();

        System.out.println("changeCatName V3");
        cat1 = new Cat("При", "Мэйкун");
        changeCatNameV3(cat1);
        System.out.println("Cat: " + cat1);

        System.out.println();
        System.out.println();

        Cat cat2 = new Cat();
        System.out.println("Cat -> " + cat2);
        cat2.setBreed("Сфинкс");
        System.out.println("Cat2 breed -> " + cat2.getBreed());
    }

    // primitives
    static void x2(int number) {
        number = number * 2;
        System.out.println("number x2: " + number);
    }

    static int returnX2(int number) {
        return number * 2;
    }

    // objects
    static void changeCatNameV1(Cat cat) {
        cat.setName("Пушистик");
        System.out.println("Cat: " + cat);
    }

    static void changeCatNameV2(Cat cat) {
        Cat catv2 = new Cat(cat.getName(), cat.getBreed());
        catv2.setName("Мурзик");
        System.out.println("Cat: " + catv2);
    }

    static void changeCatNameV3(Cat cat) {
        Cat catv3 = cat;
        catv3.setName("Ландышь");
        System.out.println("Cat: " + catv3);
    }
}
