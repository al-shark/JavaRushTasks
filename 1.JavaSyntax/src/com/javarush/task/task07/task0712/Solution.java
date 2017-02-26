package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<>(10);
        int minP = 20;
        int maxP = 20;
        int minL = Integer.MAX_VALUE;
        int maxL = Integer.MIN_VALUE;

        for (int i=0; i<10;i++)
        {
            str.add(i,reader.readLine());
            if (str.get(i).length()<minL)
            {
                minL = str.get(i).length();
                minP = i;
            }
            if (str.get(i).length()>maxL)
            {
                maxL = str.get(i).length();
                maxP = i;
            }
        }
        reader.close();

        System.out.println(str.get((minP<maxP ? minP : maxP)));
        //напишите тут ваш код
    }
}
