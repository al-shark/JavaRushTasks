package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sOut = reader.readLine();
        reader.close();

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream bOutputStream = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(bOutputStream);
        System.setOut(outputStream);

        testString.printSomething();

        System.setOut(consoleStream);

        FileOutputStream fOutputStream = new FileOutputStream(sOut);
        fOutputStream.write(bOutputStream.toByteArray());
        fOutputStream.close();

        System.out.println(bOutputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

