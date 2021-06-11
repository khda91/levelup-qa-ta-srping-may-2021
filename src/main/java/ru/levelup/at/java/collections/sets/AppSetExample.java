package ru.levelup.at.java.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ru.levelup.at.java.collections.model.PersonWithEqualsAndHashcode;
import ru.levelup.at.java.collections.model.PersonWithoutEqualsAndHashcode;

public class AppSetExample {

    public static void main(String[] args) {
        System.out.println("======");
        System.out.println("=== String Set Demo ===");
        System.out.println("======");

        stringSetDemo();

        System.out.println("======");
        System.out.println();
        System.out.println();

        System.out.println("======");
        System.out.println("=== Object w/o e&hc Set Demo ===");
        System.out.println("======");

        objectWithoutEqualsAndHashcode();

        System.out.println("======");
        System.out.println();
        System.out.println();

        System.out.println("======");
        System.out.println("=== Object with e&hc Set Demo ===");
        System.out.println("======");

        objectWithEqualsAndHashcode();

        System.out.println("======");
        System.out.println();
        System.out.println();
    }

    static void objectWithEqualsAndHashcode() {
        Set<PersonWithEqualsAndHashcode> set = new HashSet<>();

        var alex = new PersonWithEqualsAndHashcode("alex", 21);
        var max = new PersonWithEqualsAndHashcode("max", 29);
        var vova = new PersonWithEqualsAndHashcode("vova", 25);
        var gleb = new PersonWithEqualsAndHashcode("gleb", 35);

        set.addAll(Set.of(alex, max, vova, gleb));

        System.out.println("Initial set -> " + set);
        System.out.println();

        var maxim = new PersonWithEqualsAndHashcode("max", 29);
        var vladimir = vova;

        set.add(maxim);
        set.add(vladimir);

        System.out.println("Set -> " + set);
        System.out.println();

        System.out.println("max hashcode : " + max.hashCode());
        System.out.println("maxim hashcode : " + maxim.hashCode());
        System.out.println("vova hashcode : " + vova.hashCode());
        System.out.println("vladimir hashcode : " + vladimir.hashCode());

        maxim.setName("Maximilian");

        System.out.println("max name: " + max);
        System.out.println("maxim name: " + maxim);
    }

    static void objectWithoutEqualsAndHashcode() {
        Set<PersonWithoutEqualsAndHashcode> set = new HashSet<>();

        var alex = new PersonWithoutEqualsAndHashcode("alex", 21);
        var max = new PersonWithoutEqualsAndHashcode("max", 29);
        var vova = new PersonWithoutEqualsAndHashcode("vova", 25);
        var gleb = new PersonWithoutEqualsAndHashcode("gleb", 35);

        set.addAll(Set.of(alex, max, vova, gleb));

        System.out.println("Initial set -> " + set);
        System.out.println();

        var maxim = new PersonWithoutEqualsAndHashcode("max", 29);
        var vladimir = vova;

        set.add(maxim);
        set.add(vladimir);

        System.out.println("Set -> " + set);
        System.out.println();

        System.out.println("max hashcode : " + max.hashCode());
        System.out.println("maxim hashcode : " + maxim.hashCode());
        System.out.println("vova hashcode : " + vova.hashCode());
        System.out.println("vladimir hashcode : " + vladimir.hashCode());
    }

    static void stringSetDemo() {
        Set<String> set = new HashSet<>();

        set.add("mama");
        set.add("papa");
        set.add("vovka");
        set.addAll(List.of("pushok", "apple", "worm"));

        System.out.println("Initial set of strings -> " + set);
        System.out.println();

        set.add("pushok");
        System.out.println("Set of strings -> " + set);
        System.out.println();

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if ("apple".equals(next)) {
                System.out.println("WIN!!!");
            }
        }
    }
}
