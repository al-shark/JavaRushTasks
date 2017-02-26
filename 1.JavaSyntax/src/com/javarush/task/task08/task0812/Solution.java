package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> p = new ArrayList<>(10);
        int l = 1;
        int max = 1;

        for (int i=0;i<10;i++) p.add(Integer.parseInt(reader.readLine()));

        for (int i=1;i<10;i++)
        {
            if (p.get(i)==p.get(i-1)) l++;
            else
            {
                if (max<l) max=l;
                l=1;
            }
        }
        if (max<l) max=l;

        System.out.println(max);
        //напишите тут ваш код

    }
}