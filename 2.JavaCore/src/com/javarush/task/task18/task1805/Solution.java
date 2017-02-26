package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int m = Integer.MAX_VALUE;
        int b = 0;
        ArrayList<Integer> byt = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        while (inputStream.available() > 0) {
            b = inputStream.read();
            if (!byt.contains(b)) byt.add(b);
        }

        inputStream.close();

        for (int i = 0; i < (byt.size() - 1); i++)
            for (int j = i + 1; j < byt.size(); j++)
                if (byt.get(i) > byt.get(j)) {
                    m = byt.get(i);
                    byt.set(i, byt.get(j));
                    byt.set(j, m);
                }

        for (int x : byt) {
            System.out.print(x + " ");
        }
    }
}
