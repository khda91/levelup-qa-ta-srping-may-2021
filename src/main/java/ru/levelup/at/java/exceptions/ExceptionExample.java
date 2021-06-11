package ru.levelup.at.java.exceptions;

public class ExceptionExample {

    public static void main(String[] args) {
        check("12");
        check(null);
        check("ss");
    }

    static void check(String s) {
        if (s != null && !s.matches("\\d+")) {
            throw new IllegalArgumentException("This method collect only digits");
        }
        System.out.println(Integer.parseInt(s));
        System.out.println("Йюююпи");
    }
}
