package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sIn = reader.readLine();
        reader.close();

        String str;
        int count=0;
        String[] w;

        reader = new BufferedReader(new FileReader(sIn));
        while (reader.ready()) {
            str = reader.readLine();
            w = str.replaceAll("\\p{Punct}"," ").split(" ");
            count=0;
            for (int i=0;i<words.size();i++) {
                for (int j=0;j<w.length;j++) {
                    if (words.get(i).equals(w[j].trim())) {
                     count++;
                    }
                }
            }
            if (count == 2) System.out.println(str);
        }
        reader.close();
    }
}
