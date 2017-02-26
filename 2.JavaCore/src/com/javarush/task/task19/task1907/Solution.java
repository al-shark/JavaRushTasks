package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fIn = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(fIn));

        int count = 0;
        String str = "";

        while (file1.ready()) str=str+" "+file1.readLine();
        file1.close();

        str=str.replaceAll("\\p{Punct}"," ");
        String[] smas = str.split(" ");

        for (String x : smas)
            if ("world".equals(x)) count++;

        System.out.println(count);

    }
}
