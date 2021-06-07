package ru.levelup.at.java.oop;

public class App {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Sindy");
        cat.setBreed("Siam");
        cat.setAge(5);
        cat.setLifeLength(12);
        cat.setColor("brown");

        Dog dog = new Dog();
        dog.setName("Jossy");
        dog.setType("fighter");
        dog.setColor("black");

        System.out.println("Cat Sindy -> " + cat);
        System.out.println("Dog Jossy -> " + dog);

        Dog dogDog = new Dog();
        dogDog.setName("Jemma");
        dogDog.setType("пастух");
        dogDog.setColor("yellow");

        HouseAnimal dogHouseAnimal = new Dog();
        dogHouseAnimal.setName("Joise");

        Animal dogAnimal = new Dog();
        dogAnimal.setName("Tommy");

        // Object dogObject = new Dog();

        var dogVar = new Dog();
        dogVar.setType("hunter");
        dogVar.setName("Hunter");
        dogVar.move();

        // Animal animalVar = Utils.createAnimal("var");
        var animalVar = Utils.createAnimal("var");

        // приведение типов (явное)
        Animal castAnimalToCat = new Cat();
        castAnimalToCat.setName("Пушок");
        castAnimalToCat.setColor("grey");
        castAnimalToCat.setGender(Gender.MALE);

        Cat pushok = (Cat) castAnimalToCat;
        pushok.setEyeColor("green");
        pushok.setGender(Gender.MALE);
        pushok.move();

        System.out.println("Cat Pushok -> " + pushok);
        System.out.println("Cat Pushok has sex: " + pushok.getGender());
        System.out.println(pushok.eat("Рыбка"));
        System.out.println(dogVar.eat("Мясо"));

        System.out.println();
        System.out.println();

        Cat catIriska = new Cat("Ириска", Gender.FEMALE);
        System.out.println(catIriska);
    }
}
