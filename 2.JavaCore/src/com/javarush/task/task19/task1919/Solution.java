package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
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

        while (reader.ready()) {
            str = reader.readLine();
            pair=str.split(" ");
            if (salary.containsKey(pair[0])) dSal=salary.get(pair[0])+Double.parseDouble(pair[1]);
            else dSal=Double.parseDouble(pair[1]);
            salary.put(pair[0],dSal);
        }
        reader.close();

        for (Map.Entry<String,Double> x : salary.entrySet()) System.out.println(x.getKey()+" "+x.getValue());
    }
}
