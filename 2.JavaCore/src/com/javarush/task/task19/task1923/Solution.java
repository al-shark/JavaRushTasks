package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader fIn = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fOut = new BufferedWriter(new FileWriter(args[1]));

        String[] str;

        while (fIn.ready()){
            str=fIn.readLine().split(" ");
            for (String x : str)
                if (!x.matches("^\\D*$")) fOut.write(x+" ");
        }
        fIn.close();
        fOut.close();
    }

}
