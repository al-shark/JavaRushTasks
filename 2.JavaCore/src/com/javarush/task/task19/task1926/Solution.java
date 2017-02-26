package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fIn = reader.readLine();
        reader.close();

        reader = new BufferedReader(new FileReader(fIn));
        ArrayList<String> astr = new ArrayList<>();
        String result="";
        while (reader.ready()) astr.add(reader.readLine());
        reader.close();

        for (String x : astr) {
            result="";
            for (int i=x.length(); i>0 ;i--) result=result+x.charAt(i-1);
            System.out.println(result);
        }

    }
}
