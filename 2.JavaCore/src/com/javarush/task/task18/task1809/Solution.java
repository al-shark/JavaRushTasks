package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1=reader.readLine();
        String f2=reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(f1);
        FileOutputStream outputStream = new FileOutputStream(f2);

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);

            for (int i=count-1; i>=0; i--) outputStream.write((int) buffer[i]);
        }

        inputStream.close();
        outputStream.close();

    }
}
