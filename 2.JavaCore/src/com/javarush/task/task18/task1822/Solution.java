package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1=reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(s1));
        int id = Integer.parseInt(args[0]);

        while (reader.ready()) {
            s1=reader.readLine();
            if (id == Integer.parseInt(s1.split(" ")[0])) System.out.println(s1);
        }
        reader.close();

    }
}
