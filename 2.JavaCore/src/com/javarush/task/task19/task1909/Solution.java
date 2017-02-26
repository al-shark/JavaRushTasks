package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fIn = reader.readLine();
        String fOut = reader.readLine();
        reader.close();

        BufferedReader file1 = new BufferedReader(new FileReader(fIn));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fOut));

        int str=0;
        while (file1.ready()) {
            str=file1.read();
            if (str==46) str=33;
            file2.write(str);
        }
        file1.close();
        file2.close();
    }
}
