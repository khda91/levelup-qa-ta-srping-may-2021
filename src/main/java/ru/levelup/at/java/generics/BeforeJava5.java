package ru.levelup.at.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeforeJava5 {

    public static void main(String[] args) {
        List listString = new ArrayList<>();

        listString.add("mama");
        listString.add("papa");
        listString.add("vovka");
        listString.add(Double.parseDouble("3.1415"));
        listString.addAll(Arrays.asList("svetka", "stepka", "olya"));

        System.out.println(listString);

        for (Object o : listString) {
            if (o instanceof String) {
                String str = (String) o;
                System.out.println(str.substring(2));
            }
        }
    }
}
