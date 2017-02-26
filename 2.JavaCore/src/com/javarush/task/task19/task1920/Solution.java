package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        TreeMap<String,Double> salary = new TreeMap<>();
        String fName = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(fName));
        String str = "";
        String[] pair;
        double dSal;

        double dMax=Double.MIN_VALUE;

        while (reader.ready()) {
            str = reader.readLine();
            pair=str.split(" ");
            if (salary.containsKey(pair[0])) dSal=salary.get(pair[0])+Double.parseDouble(pair[1]);
            else dSal=Double.parseDouble(pair[1]);
            salary.put(pair[0],dSal);
            if (dSal>dMax) dMax=dSal;
        }
        reader.close();

        for (Map.Entry<String,Double> x : salary.entrySet())
            if (dMax==x.getValue()) System.out.println(x.getKey());
    }
}
