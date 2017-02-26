package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();

        String str = outputStream.toString();
        String[] eval = str.split(" ");
        int a = Integer.parseInt(eval[0]);
        int b = Integer.parseInt(eval[2]);
        String res="";

        if ("+".equals(eval[1].trim())) res=Integer.toString(a+b);
        else if ("-".equals(eval[1].trim())) res=Integer.toString(a-b);
        else if ("*".equals(eval[1].trim())) res=Integer.toString(a*b);

        res=str.substring(0,str.indexOf("=")+2)+res;

        System.setOut(consoleStream);

        System.out.println(res);

    }
    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

