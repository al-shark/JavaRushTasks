package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();
        Scanner scan = new Scanner(new FileInputStream(s1));

        ArrayList<Float> ar = new ArrayList<>();

        while (scan.hasNext()){
            for (String x : scan.nextLine().split(" ")) ar.add(Float.parseFloat(x));
        }
        scan.close();

        FileOutputStream f1 = new FileOutputStream(s2);
        for (Float x : ar){
            f1.write(String.format("%1$d ",Math.round(x)).getBytes());
        }
        f1.close();

    }
}
