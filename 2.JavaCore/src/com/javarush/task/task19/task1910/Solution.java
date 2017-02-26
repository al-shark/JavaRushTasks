package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        reader.close();

        String str = "";
        BufferedReader fIn = new BufferedReader(new FileReader(s1));
        while (fIn.ready()) str=str+fIn.readLine();
        fIn.close();

        str=str.replaceAll("\\p{Punct}","");
        BufferedWriter fOut = new BufferedWriter(new FileWriter(s2));
        fOut.write(str);
        fOut.close();

    }
}
