package ru.levelup.at.java.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterExceptionDemo {

    public static void main(String[] args) {
        printWithTryCatch();

        System.out.println();
        System.out.println("=====");
        System.out.println("=====");
        System.out.println();

        try {
            printWithoutCatch();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void printWithoutCatch() throws IOException {
        PrintWriter writer = null;
        try {
            System.out.println("try");
            writer = new PrintWriter(new FileWriter("out.txt"));
            //            writer = new PrintWriter(new FileWriter("test_folder"));
            for (int i = 0; i < 10; i++) {
                writer.println("printWithoutCatch");
            }
        } finally {
            System.out.println("finally");
            if (writer != null) {
                writer.close();
            }
            //            writer.close(); // == null.close();
        }
    }

    static void printWithTryCatch() {
        PrintWriter writer = null;
        try {
            System.out.println("try");
            //            writer = new PrintWriter(new FileWriter("out.txt"));
            writer = new PrintWriter(new FileWriter("test_folder"));
            for (int i = 0; i < 10; i++) {
                writer.println("Some text\n");
            }
        } catch (IOException e) {
            System.out.println("catch");
            System.err.println("File was not found!");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            if (writer != null) {
                writer.close();
            }
            //            writer.close(); // == null.close();
        }
    }
}
