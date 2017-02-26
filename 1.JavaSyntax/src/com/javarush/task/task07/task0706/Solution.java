package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String res = "";
        int even = 0;
        int odd = 0;
        int[] dom = new int[15];
        int r=0;

        for (int i = 0; i<15;i++){
            dom[i]=Integer.parseInt(reader.readLine());
        if ((i % 2)==0) even=even+dom[i];
        else odd=odd+dom[i];
        }

        if (odd>even) res="В домах с нечетными номерами проживает больше жителей.";
        else res="В домах с четными номерами проживает больше жителей.";

        System.out.println(res);

        //напишите тут ваш код
    }
}
