package ru.levelup.at.java.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AppMapExample {

    public static void main(String[] args) {
        System.out.println("======");
        System.out.println("=== Map <String, String> Demo ===");
        System.out.println("======");

        mapStringStringDemo();

        System.out.println("=====");
        System.out.println();
    }

    static void mapStringStringDemo() {
        Map<String, String> map = new HashMap<>();

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        map.put("key5", "value5");

        System.out.println("Initial map -> " + map);
        System.out.println();

        System.out.println("map value by key -> " + map.get("key4"));

        map.put("key3", "valuevalue8");
        map.put("key5", "value19");
        System.out.println("Map -> " + map);
        System.out.println();

        if (!map.containsKey("key6")) {
            map.put("key6", "value6");
        }

        map.putIfAbsent("key6", "value66");
        map.putIfAbsent("key7", "value77");

        System.out.println("Map -> " + map);
        System.out.println();

        for (Entry<String, String> entity : map.entrySet()) {
            System.out.println(entity.getKey() + " || " + entity.getValue());
        }
        System.out.println();
    }
}
