package ru.levelup.at.java.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppListExample {

    public static void main(String[] args) {
        System.out.println("======");
        System.out.println("=== Array List Demo ===");
        System.out.println("======");

        arrayListDemo();

        System.out.println("======");
        System.out.println();
        System.out.println();
    }

    // ArrayList
    static void arrayListDemo() {
        List<String> listString = new ArrayList<>(); // new LinkedList();

        listString.add("mama");
        listString.add("papa");
        listString.add("vovka");
        listString.addAll(Arrays.asList("svetka", "stepka", "olya"));

        System.out.println(listString);
        System.out.println();

        System.out.println("List size -> " + listString.size());
        System.out.println();

        listString.add(2, "techa");
        System.out.println("add element by index -> " + listString);
        System.out.println();

        listString.set(5, "zhanna");
        System.out.println("replace by index -> " + listString);
        System.out.println();

        listString.remove("olya");
        System.out.println("remove element as object -> " + listString);
        System.out.println();

        listString.remove(listString.size() - 1);
        System.out.println("remove element by index -> " + listString);
        System.out.println();

        System.out.println("get element by index -> " + listString.get(0));
        System.out.println();
    }
}
