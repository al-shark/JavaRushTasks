package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream(args[0]);
        int p1=0,p2=0;

        while (stream.available()>0) {
            if (stream.read() == 32) p2++;
            p1++;
        }

        stream.close();

        float res = (float) p2/p1*100;

        System.out.println(String.format("%1$.2f",res));
    }
}
