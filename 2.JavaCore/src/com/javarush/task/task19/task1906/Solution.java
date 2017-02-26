package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fIn = reader.readLine();
        String fOut = reader.readLine();
        reader.close();

        FileReader file1 = new FileReader(fIn);
        FileWriter file2 = new FileWriter(fOut);

        int count = 1;

        while (file1.ready()) {
            if (count % 2 ==0) file2.write(file1.read());
            else file1.read();
            count++;
        }

        file1.close();
        file2.close();
    }
}
